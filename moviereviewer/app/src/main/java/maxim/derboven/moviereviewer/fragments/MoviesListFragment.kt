package maxim.derboven.moviereviewer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.adapters.MoviesListAdapter
import maxim.derboven.moviereviewer.databinding.FragmentMoviesListBinding
import maxim.derboven.moviereviewer.databinding.FragmentPostersBinding
import maxim.derboven.moviereviewer.model.getMovies
import maxim.derboven.moviereviewer.services.RestClient
import maxim.derboven.moviereviewer.view_models.MovieViewModel


class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!


    lateinit var recyclerView: RecyclerView;
    val viewModel: MovieViewModel by viewModels()
    lateinit var mCallback: ItemClicked;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        binding.movieViewModel = viewModel
        binding.lifecycleOwner = this
        val adapter = MoviesListAdapter(this)
        binding.rvItems.adapter= adapter
        binding.rvItems.setHasFixedSize(false)
        mCallback = parentFragment as OverviewFragment
        adapter.setOnItemClickListener(object : MoviesListAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                mCallback.changeMovie(position)
            }
        })
        viewModel.restClient.movies.observe(viewLifecycleOwner, Observer{
            val adapter = (binding.rvItems.adapter!! as MoviesListAdapter)
            adapter.setData(it)
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView  = view.findViewById(R.id.rv_items)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = binding.rvItems.adapter

    }

    interface ItemClicked {
        fun changeMovie(pos: Int)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}