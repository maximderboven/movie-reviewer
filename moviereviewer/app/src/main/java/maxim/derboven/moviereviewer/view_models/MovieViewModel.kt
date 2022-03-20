package maxim.derboven.moviereviewer.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.services.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel: ViewModel() {
    init {
        fetchAllMovies()
    }

    private val _response: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>> ()
    }
    val response: LiveData<List<Movie>> by lazy {
        return@lazy _response
    }

    private fun fetchAllMovies() {
        API.MovieService.getAllMovies().enqueue(
            object : Callback<List<Movie>> {
                override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                    _response.value = response.body()
                }

                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                    Log.e("Er ging iets mis", t.message!!)
                }
            }
        )
    }
}