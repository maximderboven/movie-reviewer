package maxim.derboven.moviereviewer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import maxim.derboven.moviereviewer.R
import maxim.derboven.moviereviewer.adapters.MoviePosterAdapter
import maxim.derboven.moviereviewer.databinding.FragmentPostersBinding
import maxim.derboven.moviereviewer.model.getMovies

class PostersFragment : Fragment() {

    private var _binding: FragmentPostersBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var layoutManager = LinearLayoutManager(activity)

        val data = getMovies()

        val recyclerView = view.findViewById<RecyclerView>(R.id.posters)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MoviePosterAdapter (this, data);
        recyclerView.setHasFixedSize(true)
    }
}