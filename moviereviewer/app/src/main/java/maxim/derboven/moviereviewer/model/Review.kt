package maxim.derboven.moviereviewer.model

import java.time.LocalDate

data class Review(
    val reviewId: Int,
    val author: String,
    val rating: Int,
    val comment: String,
    val createdAt: LocalDate,
    val published: Boolean,
)