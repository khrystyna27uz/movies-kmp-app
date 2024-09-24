package com.khrystynasika.movievision.movies.domain

data class MovieDetails(
    val movie: Movie,
    val fullCast: FullCast,
    val trailer: Trailer
)

data class FullCast(
    val director: Director,
    val actors: List<Actor>
) {
    data class Director(
        val image: String,
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

data class Trailer(
    val title: String?,
    val videoUrl: String?,
    val type: String?
)
