package maxim.derboven.moviereviewer.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.adapters.MoviesListAdapter
import maxim.derboven.moviereviewer.model.getMovies


class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    lateinit var recyclerView: RecyclerView;
    lateinit var mCallback: ItemClicked;

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_movies_list,container,false);
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView  = view.findViewById(R.id.rv_items)
        recyclerView.setHasFixedSize(true)

        var adapter = MoviesListAdapter(this, getMovies())
        recyclerView.adapter = adapter

        mCallback = parentFragment as OverviewFragment
        adapter.setOnItemClickListener(object : MoviesListAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                mCallback.changeMovie(position)
            }
        })
    }

    interface ItemClicked {
        fun changeMovie(pos: Int)
    }
}