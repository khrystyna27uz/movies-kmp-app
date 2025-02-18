package com.khrystynasika.movievision.movies.domain

import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    fun getMovies(page: Int): Flow<List<Movie>>

    fun getUpcoming(page: Int): Flow<List<Movie>>

    fun getMoviesNowPlaying(page: Int): Flow<List<Movie>>

    fun getMoviesPastYear(page: Int): Flow<List<Movie>>

    fun getMoviesPopular(page: Int): Flow<List<Movie>>

    fun getMoviesTopRated(page: Int): Flow<List<Movie>>

    fun getMovieDetailsById(movieId: Int): Flow<MovieDetails>

    fun getBrowseAll(page: Int): Flow<List<Movie>>

    fun getMoviesFromSearch(query: String, page: Int): Flow<List<Movie>>
}
