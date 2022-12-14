package maxim.derboven.moviereviewer.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate

data class Movie(
    val movieId: Int,
    val comingSoon: Boolean,
    val title: String,
    val released: LocalDate,
    val runtime: Int,
    val type: Mediatype,
    val plot: String,
    val poster: String
)