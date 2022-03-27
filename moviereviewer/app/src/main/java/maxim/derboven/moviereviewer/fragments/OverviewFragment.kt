package maxim.derboven.moviereviewer.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import maxim.derboven.moviereviewer.R


class OverviewFragment : Fragment(), MoviesListFragment.ItemClicked,
    MoviesFragment.ReviewClicked {

    private var savedInstanceState: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View? = inflater.inflate(R.layout.activity_main, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.savedInstanceState = savedInstanceState
        if (savedInstanceState ==null) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //bijhouden van de state (welke open is) bij orientatie draaien
                //if savedInstanceState == null
            childFragmentManager.beginTransaction()
                .replace(R.id.content,  MoviesListFragment(), "fragment-a")
                .commit();
//                .hide(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
//                .hide(childFragmentManager.findFragmentById(R.id.fragment_reviews)!!)
//                .show(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
//                //.addToBackStack(null)
//                .commit()
        } else {
            childFragmentManager.beginTransaction()
                .show(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
                .show(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
                .hide(childFragmentManager.findFragmentById(R.id.fragment_reviews)!!)
                .commit()
        }
        }
    }

    override fun onStart() {
        super.onStart()
        val view = requireView()


    }

    override fun changeMovie(pos: Int) {
        val f = MoviesFragment()
        val bdl = Bundle(1)
        bdl.putInt("movieId", pos)
        f.setArguments(bdl)
        //the phone is in portrait mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            childFragmentManager.beginTransaction()
                .replace(R.id.content,  f, "fragment-b")
                .addToBackStack("a")
                .commit();
        } else {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_details, f, "fragment-b")
                .show(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
                .show(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
                .hide(childFragmentManager.findFragmentById(R.id.fragment_reviews)!!)
                .commit()
            val frag: MoviesFragment? =
                childFragmentManager.findFragmentById(R.id.fragment_details) as MoviesFragment?
            frag?.fillInfo(pos)
        }
    }

    override fun showReviews(movieId: Int, movieTitle: String) {
        val f = ReviewsFragment()
        val bdl = Bundle(2)
        bdl.putString("MovieTitleKEY", movieTitle)
        bdl.putInt("MovieIDKey",movieId)
        f.setArguments(bdl)
        //the phone is in portrait mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            childFragmentManager.beginTransaction()
                .replace(R.id.content, f, "fragment-c")
                .addToBackStack("b")
                .commit();
        } else {
            childFragmentManager.beginTransaction()
                .hide(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
                .show(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
                .replace(R.id.fragment_reviews, f, "fragment-c")
                .show(childFragmentManager.findFragmentById(R.id.fragment_reviews)!!)
                .commit()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}