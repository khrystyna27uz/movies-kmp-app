package com.khrystynasika.movievision.movies.domain

data class Movie(
    val id: String,
    val title: String,
    val year: Float,
    val image: String,
    val imDbRating: Float,
    val imDbRatingCount: Int,
)
