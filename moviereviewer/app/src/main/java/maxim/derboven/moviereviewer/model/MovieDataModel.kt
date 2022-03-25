package maxim.derboven.moviereviewer.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate

@JsonClass(generateAdapter = true)
data class MovieDataModel(
    @Json(name = "id")
    val movieId: Int,

    @Json(name = "comingSoon")
    val comingSoon: Boolean,

    @Json(name = "title")
    val title: String,

    @Json(name = "released")
    val released: String,

    @Json(name = "runtime")
    val runtime: Int,

    @Json(name = "type")
    val type: Mediatype,

    @Json(name = "plot")
    val plot: String,

    @Json(name = "poster")
    val poster: String
) {
    fun toMovie():Movie {
        return Movie(movieId,comingSoon,title, LocalDate.parse(released),runtime,type,plot,poster)
    }
}