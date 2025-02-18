package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.roundToInt

@Serializable
internal data class MovieResult(
    val page: Int? = null,
    val results: List<Result> = emptyList()
) {

    @Serializable
    data class Result(
        val id: Int,
        val title: String,
        @SerialName("release_date")
        val releaseDate: String,
        @SerialName("backdrop_path")
        val backdropPath: String?,
        @SerialName("poster_path")
        val posterPath: String?,
        @SerialName("genre_ids")
        val genreIds: List<Int>,
        @SerialName("vote_average")
        val voteAverage: Float,
        @SerialName("vote_count")
        val voteCount: Int
    )
}

internal fun MovieResult.Result.toMovie(genre: GenreResult): Movie =
    Movie(
        id = id,
        title = title,
        year = releaseDate.split("-").first().toString(),
        image = IMAGE_PATH_PART + posterPath,
        backImage = IMAGE_PATH_PART + backdropPath,
        genres = toGenres(genre),
        rating = voteAverage.roundToDecimals(1),
        overview = "",
        tagline = ""
    )

private fun MovieResult.Result.toGenres(genre: GenreResult): List<String> =
    genre.genres.filter { it.id in genreIds }.map { it.name }

internal fun Float.roundToDecimals(decimals: Int): Float {
    var dotAt = 1
    repeat(decimals) { dotAt *= 10 }
    val roundedValue = (this * dotAt).roundToInt()
    return (roundedValue / dotAt) + (roundedValue % dotAt).toFloat() / dotAt
}
