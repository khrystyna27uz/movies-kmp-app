package com.khrystynasika.movievision.movies.domain

import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getMovies(page: Int): Flow<List<Movie>>

    fun getUpcoming(page: Int): Flow<List<Movie>>

    fun getMoviesNowPlaying(): Flow<List<Movie>>

    fun getMoviesPastYear(): Flow<List<Movie>>

    fun getMoviesPopular(): Flow<List<Movie>>

    fun getMoviesTopRated(): Flow<List<Movie>>

    fun getMovieDetailsById(movieId: Int): Flow<MovieDetails>

    fun getBrowseAll(page: Int): Flow<List<Movie>>

    fun getMoviesFromSearch(query: String): Flow<List<Movie>>
}
