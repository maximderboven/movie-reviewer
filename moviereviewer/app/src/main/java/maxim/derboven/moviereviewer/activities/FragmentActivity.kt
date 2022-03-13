package maxim.derboven.moviereviewer.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.fragments.MoviesFragment
import maxim.derboven.moviereviewer.fragments.MoviesListFragment


class FragmentActivity : AppCompatActivity(R.layout.activity_main), MoviesListFragment.ItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //the phone is in portrait mode

        if (findViewById<View>(R.id.layout_default) != null) {
            //bijhouden van de state (welke open is) bij orientatie draaien
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .hide(supportFragmentManager.findFragmentById(R.id.fragment_details)!!)
                    .show(supportFragmentManager.findFragmentById(R.id.fragment_list)!!)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .show(supportFragmentManager.findFragmentById(R.id.fragment_details)!!)
                    .hide(supportFragmentManager.findFragmentById(R.id.fragment_list)!!)
                    .addToBackStack(null)
                    .commit()
            }
        }

        //the phone is in land mode
        if (findViewById<View>(R.id.layout_landscape) != null) {
            supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.findFragmentById(R.id.fragment_details)!!)
                .show(supportFragmentManager.findFragmentById(R.id.fragment_list)!!)
                .commit()
        }


    }

    override fun changeMovie(pos: Int) {
        val frag: MoviesFragment? =
            supportFragmentManager.findFragmentById(R.id.fragment_details) as MoviesFragment?
        frag?.fillInfo(pos)

        //the phone is in portrait mode
        if (findViewById<View>(R.id.layout_default) != null) {
            supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.findFragmentById(R.id.fragment_details)!!)
                .hide(supportFragmentManager.findFragmentById(R.id.fragment_list)!!)
                .addToBackStack(null)
                .commit()
        }
    }
}