package maxim.derboven.moviereviewer.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.model.getMovies

class MoviesFragment : Fragment(R.layout.fragment_movies) {
    //knoppen
    var counter = 0;
    lateinit var btnNext: Button;
    lateinit var btnPrevious: Button;

    //textvelden
    lateinit var txtTitle: TextView;
    lateinit var txtReleasedate: TextView;
    lateinit var txtRuntime: TextView;
    lateinit var txtPlot: TextView;

    //images
    lateinit var imgComingsoon: ImageView;
    lateinit var imgPoster: ImageView;



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        btnNext = view.findViewById(R.id.btnNext);
        btnPrevious = view.findViewById(R.id.btnPrevious);
        txtTitle = view.findViewById(R.id.txtTitle);
        txtReleasedate = view.findViewById(R.id.txtReleasedate);
        txtRuntime = view.findViewById(R.id.txtRuntime);
        txtPlot = view.findViewById(R.id.txtPlot);
        imgComingsoon = view.findViewById(R.id.imgComingsoon);
        imgPoster = view.findViewById(R.id.imgPoster);

        btnNext.setOnClickListener{next()};
        btnPrevious.setOnClickListener{previous()};
        fillInfo(0);
    }

    private fun previous() {
        fillInfo(--counter);
        btnPrevious.isEnabled = counter != 0
        btnNext.isEnabled = true;
    }

    private fun next() {
        fillInfo(++counter);
        btnNext.isEnabled = counter != getMovies().size-1
        btnPrevious.isEnabled = true;
    }

    fun fillInfo(pos:Int?) {
        var index:Int=0
        if (pos != null) {
            index=pos;
        }
        print(getMovies()[index].plot)
        print(index);
        txtPlot.text = getMovies()[index].plot;
        txtReleasedate.text = getMovies()[index].released.toString();
        txtRuntime.text = getMovies()[index].runtime.toString() + "min.";
        txtTitle.text = getMovies()[index].title;

        imgPoster.setImageResource(resources.getIdentifier("@drawable/"+getMovies()[index].poster, null,
            activity?.packageName
        ))
        if (getMovies()[index].comingSoon) {
            imgComingsoon.setImageResource(R.drawable.comingsoon)
        } else {imgComingsoon.setImageDrawable(null)}
    }

}