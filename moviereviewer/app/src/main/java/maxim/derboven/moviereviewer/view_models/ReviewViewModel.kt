package maxim.derboven.moviereviewer.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.model.Review
import maxim.derboven.moviereviewer.services.RestClient

class ReviewViewModel(): ViewModel() {
    val restClient: RestClient = RestClient()
    fun getReviewsFromMovie(id:Int) {
        restClient.fetchReviewsFromMovie(id+1)
    }
}