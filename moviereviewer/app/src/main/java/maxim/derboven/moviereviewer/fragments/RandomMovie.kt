package maxim.derboven.moviereviewer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.model.getMovies
import kotlin.random.Random

class RandomMovie : Fragment(R.layout.fragment_movies) {

    //knoppen
    lateinit var dataset: Array<Movie>
    var counter: Int = 0
    lateinit var btnNext: Button;
    lateinit var btnPrevious: Button;
    lateinit var btnReviews: Button;

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

        dataset = getMovies()
        counter = Random.nextInt(dataset.size)

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
        fillInfo(counter);
    }

    private fun previous() {
        fillInfo(--counter);
        btnNext.isEnabled = true;
    }

    private fun next() {
        fillInfo(++counter);
        btnPrevious.isEnabled = true;
    }

    fun fillInfo(pos:Int?) {
        btnPrevious.isEnabled = counter != 0
        btnNext.isEnabled = counter != dataset.size-1
        var index:Int=0
        if (pos != null) {
            index=pos;
        }
        print(dataset[index].plot)
        print(index);
        txtPlot.text = dataset[index].plot;
        txtReleasedate.text = dataset[index].released.toString();
        txtRuntime.text = dataset[index].runtime.toString() + "min.";
        txtTitle.text = dataset[index].title;

        imgPoster.setImageResource(resources.getIdentifier("@drawable/"+dataset[index].poster, null,
            activity?.packageName
        ))
        if (dataset[index].comingSoon) {
            imgComingsoon.setImageResource(R.drawable.comingsoon)
        } else {imgComingsoon.setImageDrawable(null)}
    }
}