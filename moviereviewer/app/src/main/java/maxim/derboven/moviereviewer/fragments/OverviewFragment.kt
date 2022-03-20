package maxim.derboven.moviereviewer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.activities.NavigationActivity

class OverviewFragment : Fragment(), MoviesListFragment.ItemClicked {

    private var savedInstanceState: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.savedInstanceState = savedInstanceState
    }

    override fun onStart() {
        super.onStart()
        val view = requireView()

        if (view.findViewById<View>(R.id.layout_default) != null) {
            //bijhouden van de state (welke open is) bij orientatie draaien
            if (savedInstanceState == null) {
                childFragmentManager.beginTransaction()
                    .hide(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
                    .show(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
                    .commit()
            } else {
                childFragmentManager.beginTransaction()
                    .show(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
                    .hide(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
                    .addToBackStack(null)
                    .commit()
            }
        }

        //the phone is in landscape mode
        if (view.findViewById<View>(R.id.layout_landscape) != null) {
            childFragmentManager.beginTransaction()
                .show(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
                .show(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
                .commit()
        }
    }

    override fun changeMovie(pos: Int) {

        val frag: MoviesFragment? =
            childFragmentManager.findFragmentById(R.id.fragment_details) as MoviesFragment?
        frag?.fillInfo(pos)

        //the phone is in portrait mode
        if (view?.findViewById<View>(R.id.layout_default) != null) {
            childFragmentManager.beginTransaction()
                .show(childFragmentManager.findFragmentById(R.id.fragment_details)!!)
                .hide(childFragmentManager.findFragmentById(R.id.fragment_list)!!)
                .addToBackStack(null)
                .commit()
        }
    }

}