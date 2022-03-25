package maxim.derboven.moviereviewer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.adapters.ReviewsAdapter
import maxim.derboven.moviereviewer.databinding.FragmentReviewsBinding
import maxim.derboven.moviereviewer.view_models.ReviewViewModel


class ReviewsFragment() : Fragment(R.layout.fragment_reviews) {

    private var _binding: FragmentReviewsBinding? = null
    private val binding get() = _binding!!

    lateinit var txtTitle: TextView;
    lateinit var recyclerView: RecyclerView;
    val viewModel: ReviewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentReviewsBinding.inflate(inflater, container, false)
        binding.reviewViewModel = viewModel
        binding.lifecycleOwner = this
        val adapter = ReviewsAdapter(this)
        binding.rvItems.adapter= adapter
        binding.rvItems.setHasFixedSize(false)

        viewModel.restClient.reviews.observe(viewLifecycleOwner, Observer{
            val adapter = (binding.rvItems.adapter!! as ReviewsAdapter)
            adapter.setData(it)
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView  = view.findViewById(R.id.rv_items)
        txtTitle = view.findViewById(R.id.txtMovieTitle)
        txtTitle.text = getArguments()?.getString("MovieTitleKEY")
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = binding.rvItems.adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}