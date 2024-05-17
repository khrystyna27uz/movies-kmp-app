package com.khrystynasika.movievision.movies.domain

import kotlin.time.Duration

data class MovieDetails(
    val movie: Movie,
    val fullCast: FullCast,
    val review: Review,
    val trailer: Trailer,
    val poster: String,
)

data class FullCast(
    val directors: List<Director>,
    val actors: List<Actor>
) {
    data class Director(
        val job: String,
        val name: String,
        val description: String,
    )

    data class Actor(
        val image: String,
        val name: String,
        val role: String
    )
}

data class Review(
    val username: String,
    val helpful: Helpful,
    val title: String,
    val content: String
) {
    data class Helpful(
        val positive: Int,
        val total: Int,
    )
}

data class Trailer(
    val title: String,
    val videoUrl: String,
    val thumbnailUrl: String,
    val duration: Duration,
)
