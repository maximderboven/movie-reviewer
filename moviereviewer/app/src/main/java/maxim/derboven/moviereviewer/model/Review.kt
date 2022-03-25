package maxim.derboven.moviereviewer.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate
@JsonClass(generateAdapter = true)
data class Review(
    @Json(name = "id")
    val reviewId: Int,
    @Json(name = "author")
    val author: String,
    @Json(name = "rating")
    val rating: Int,
    @Json(name = "comment")
    val comment: String,
    @Json(name = "createdAt")
    val createdAt: String,
    @Json(name = "published")
    val published: Boolean,
)