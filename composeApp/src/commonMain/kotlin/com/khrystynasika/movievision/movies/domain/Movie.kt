package com.khrystynasika.movievision.movies.domain

data class Movie(
    val id: Int,
    val title: String,
    val year: String,
    val image: String,
    val backImage: String,
    val genres: List<String>,
    val rating: Float,
    val overview: String,
    val tagline: String
)