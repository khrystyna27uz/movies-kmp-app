package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsResult(
    val id: Int,
    val title: String,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    val genres: List<Genre>,
    @SerialName("vote_average")
    val voteAverage: Float,
    @SerialName("release_date")
    val releaseDate: String,
    val overview: String,
    val tagline: String
) {
    @Serializable
    data class Genre(
        val id: Int,
        val name: String
    )
}

fun MovieDetailsResult.toMovie(): Movie =
    Movie(
        id = id,
        title = title,
        year = releaseDate.split("-").first().toString(),
        image = IMAGE_PATH_PART + backdropPath,
        backImage = IMAGE_PATH_PART + backdropPath,
        genres = genres.map { it.name },
        rating = voteAverage.roundToDecimals(1),
        overview = overview,
        tagline = tagline
    )