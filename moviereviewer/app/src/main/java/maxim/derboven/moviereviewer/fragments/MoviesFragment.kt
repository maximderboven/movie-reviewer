package maxim.derboven.moviereviewer.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.model.getMovies


class MoviesFragment() : Fragment(R.layout.fragment_movies) {

    //knoppen
    var counter = 0;
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

    lateinit var mCallback: ReviewClicked;
    val data = getMovies()


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
        btnReviews = view.findViewById(R.id.btnDetails)

        if(arguments?.getInt("movieId") != null) {
            counter = arguments?.getInt("movieId")!!
        } else {
            counter = 0
        }


        btnNext.setOnClickListener { next() };
        btnPrevious.setOnClickListener { previous() };
        mCallback = parentFragment as OverviewFragment
        btnReviews.setOnClickListener {
            mCallback.showReviews(counter,data[counter].title)
        }

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

    fun fillInfo(pos: Int?) {
        btnPrevious.isEnabled = counter != 0
        btnNext.isEnabled = counter != data.size - 1
        var index: Int = 0
        if (pos != null) {
            index = pos;
        }
        print(data[index].plot)
        print(index);
        txtPlot.text = data[index].plot;
        txtReleasedate.text = data[index].released.toString();
        txtRuntime.text = data[index].runtime.toString() + "min.";
        txtTitle.text = data[index].title;

        imgPoster.setImageResource(
            resources.getIdentifier(
                "@drawable/" + data[index].poster, null,
                activity?.packageName
            )
        )
        if (data[index].comingSoon) {
            imgComingsoon.setImageResource(R.drawable.comingsoon)
        } else {
            imgComingsoon.setImageDrawable(null)
        }
    }

    interface ReviewClicked {
        fun showReviews(movieId: Int, movieTitle: String)
    }
}
