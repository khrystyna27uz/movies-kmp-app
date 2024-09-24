package com.khrystynasika.movievision.movies.data

import kotlinx.serialization.Serializable

@Serializable
data class GenreResult(
    val genres: List<Genre>
) {
    @Serializable
    data class Genre(
        val id: Int,
        val name: String
    )
}