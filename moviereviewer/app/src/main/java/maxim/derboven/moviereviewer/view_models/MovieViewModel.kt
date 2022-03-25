package maxim.derboven.moviereviewer.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.services.RestClient

class MovieViewModel: ViewModel() {
    val restClient:RestClient = RestClient()
    init {
        restClient.fetchAllMovies()
    }
    val movies:LiveData<List<Movie>> = restClient.movies
}