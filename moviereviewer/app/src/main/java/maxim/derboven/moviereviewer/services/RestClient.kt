package maxim.derboven.moviereviewer.services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.model.MovieDataModel
import maxim.derboven.moviereviewer.model.Review
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val BASE_URL = "http:/10.0.2.2:3000"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit: Retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

object API {
    val REST_CLIENT: IRestClient by lazy { retrofit.create(IRestClient::class.java) }
}

class RestClient {
    private val _movies: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>()
    }
    val movies: LiveData<List<Movie>> by lazy {
        return@lazy _movies
    }

    private val _reviews: MutableLiveData<List<Review>> by lazy {
        MutableLiveData<List<Review>>()
    }

    val reviews: LiveData<List<Review>> by lazy {
        return@lazy _reviews
    }

    fun fetchAllMovies() {
        API.REST_CLIENT.getAllMovies().enqueue(
            object : Callback<List<MovieDataModel>> {
                override fun onResponse(call: Call<List<MovieDataModel>>, response: Response<List<MovieDataModel>>) {

                    _movies.value = response.body()?.map {
                        it.toMovie()
                    }
                }

                override fun onFailure(call: Call<List<MovieDataModel>>, t: Throwable) {
                    Log.e("Er ging iets mis", t.message!!)
                }
            }
        )
    }

    fun fetchReviewsFromMovie(id: Int) {
        API.REST_CLIENT.getReviewsFromMovie(id).enqueue(
            object : Callback<List<Review>> {
                override fun onResponse(
                    call: Call<List<Review>>,
                    response: Response<List<Review>>
                ) {
                    _reviews.value = response.body()
                }

                override fun onFailure(call: Call<List<Review>>, t: Throwable) {
                    Log.e("Er ging iets mis", t.message!!)
                }
            }
        )
    }
}


interface IRestClient {
    @GET("movies")
    fun getAllMovies(): Call<List<MovieDataModel>>

    @GET("reviews")
    fun getReviewsFromMovie(@Query("movieId") movieId: Int): Call<List<Review>>
}