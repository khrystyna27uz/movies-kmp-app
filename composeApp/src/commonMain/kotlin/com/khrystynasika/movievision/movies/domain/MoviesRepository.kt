package com.khrystynasika.movievision.movies.domain

import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getMovies(): Flow<List<Movie>>

    fun getUpcoming(): Flow<List<Movie>>

    fun getMovieById(movieId: String): Flow<Movie>

    fun getMovieDetailsById(movieId: String): Flow<MovieDetails>
}
