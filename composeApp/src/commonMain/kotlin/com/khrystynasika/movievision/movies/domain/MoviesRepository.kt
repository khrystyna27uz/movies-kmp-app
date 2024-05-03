package com.khrystynasika.movievision.movies.domain

import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getMovies(): Flow<List<Movie>>
}
