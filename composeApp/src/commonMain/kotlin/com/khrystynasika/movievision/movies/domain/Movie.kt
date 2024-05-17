package com.khrystynasika.movievision.movies.domain

import kotlin.time.Duration

data class Movie(
    val id: String,
    val title: String,
    val year: Float,
    val image: String,
    val genres: List<String>,
    val rating: IMDBRating,
    val contentRating: String?,
    val duration: Duration,
)

data class IMDBRating(
    val rating: Float,
    val count: Int,
)
