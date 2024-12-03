package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MovieDetails
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip

class MoviesRepositoryImpl internal constructor(
    private val movieApi: MovieApi,
) : MoviesRepository {

    override fun getMovies(page: Int): Flow<List<Movie>> =
        movieApi.getMovies(page = page).withGenres()

    override fun getUpcoming(page: Int): Flow<List<Movie>> =
        movieApi.getMoviesUpcoming().withGenres()

    override fun getMoviesNowPlaying(): Flow<List<Movie>> =
        movieApi.getMoviesNowPlaying().withGenres()

    override fun getMoviesPastYear(): Flow<List<Movie>> =
        movieApi.getMoviesPastYear().withGenres()

    override fun getMoviesPopular(): Flow<List<Movie>> =
        movieApi.getMoviesPopular().withGenres()

    override fun getMoviesTopRated(): Flow<List<Movie>> =
        movieApi.getMoviesTopRated().withGenres()

    override fun getMovieDetailsById(movieId: Int): Flow<MovieDetails> =
        combine(
            movieApi.getMovieById(id = movieId),
            movieApi.getCastCrew(movieId),
            movieApi.getTrailer(movieId)
        ) { movie, cast, trailer ->
            MovieDetails(
                movie = movie.toMovie(),
                fullCast = cast.toFullCast(),
                trailer = trailer.toTrainer()
            )
        }

    override fun getBrowseAll(page: Int): Flow<List<Movie>> =
        movieApi.getMovies(page = page).withGenres()

    override fun getMoviesFromSearch(query: String): Flow<List<Movie>> =
        movieApi.getMoviesFromSearch(query = query).withGenres()

    private fun Flow<MovieResult>.withGenres(): Flow<List<Movie>> =
        zip(movieApi.getGenres()) { movie, genre ->
            movie.results.map {
                it.copy().toMovie(genre)
            }
        }
}
