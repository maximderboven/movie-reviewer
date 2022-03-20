package maxim.derboven.moviereviewer.services

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import maxim.derboven.moviereviewer.model.Movie
import maxim.derboven.moviereviewer.model.Review
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "http:/10.0.2.2:3000"

interface IMovieService {
    @GET("movies")
    fun getAllMovies(): Call<List<Movie>>

    @GET("reviews")
    fun getReviewsFromMovie(@Path("movieId") movieId: Int): Call<List<Review>>
}

val retrofit: Retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(
        "$BASE_URL/"
    ).build()

object API {
    val MovieService: IMovieService by lazy { retrofit.create(IMovieService::class.java) }
}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()