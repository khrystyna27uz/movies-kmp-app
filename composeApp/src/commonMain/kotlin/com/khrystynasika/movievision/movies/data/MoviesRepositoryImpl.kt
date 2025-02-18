package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MovieDetails
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import com.khrystynasika.movievision.util.getEndOfLastYear
import com.khrystynasika.movievision.util.getMovieCurrentDate
import com.khrystynasika.movievision.util.getMovieMonthsAgo
import com.khrystynasika.movievision.util.getMovieYearsAgo
import com.khrystynasika.movievision.util.getStartOfLastYear
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip

class MoviesRepositoryImpl internal constructor(
    private val movieApi: MovieApi,
) : MoviesRepository {

    override fun getMovies(
        page: Int,
    ): Flow<List<Movie>> =
        movieApi.getMovies(
            page = page,
            minReleaseDate = getMovieYearsAgo(years = 5),
            maxReleaseDate = getMovieCurrentDate(),
        ).withGenres()

    override fun getUpcoming(page: Int): Flow<List<Movie>> =
        movieApi.getMoviesUpcoming(
            page = page,
            minReleaseDate = getMovieCurrentDate(),
        ).withGenres()

    override fun getMoviesNowPlaying(page: Int): Flow<List<Movie>> =
        movieApi.getMoviesNowPlaying(
            page = page,
            minReleaseDate = getMovieMonthsAgo(months = 4),
            maxReleaseDate = getMovieCurrentDate(),
        ).withGenres()

    override fun getMoviesPastYear(page: Int): Flow<List<Movie>> =
        movieApi.getMoviesPastYear(
            page = page,
            minReleaseDate = getStartOfLastYear(),
            maxReleaseDate = getEndOfLastYear(),
        ).withGenres()

    override fun getMoviesPopular(page: Int): Flow<List<Movie>> =
        movieApi.getMoviesPopular(page = page).withGenres()

    override fun getMoviesTopRated(page: Int): Flow<List<Movie>> =
        movieApi.getMoviesTopRated(page = page).withGenres()

    override fun getMovieDetailsById(movieId: Int): Flow<MovieDetails> =
        combine(
            movieApi.getMovieById(id = movieId),
            movieApi.getCastCrew(movieId),
            movieApi.getTrailer(movieId)
        ) { movie, cast, trailer ->
            MovieDetails(
                movie = movie.toMovie(),
                fullCast = cast.toFullCast(),
                trailer = trailer.toTrainer(),
            )
        }

    override fun getBrowseAll(page: Int): Flow<List<Movie>> =
        movieApi.getMovies(
            page = page,
            minReleaseDate = getMovieYearsAgo(5),
            maxReleaseDate = getMovieCurrentDate(),
        ).withGenres()

    override fun getMoviesFromSearch(query: String, page: Int): Flow<List<Movie>> =
        movieApi.getMoviesFromSearch(query = query, page = page).withGenres()

    private fun Flow<MovieResult>.withGenres(): Flow<List<Movie>> =
        zip(movieApi.getGenres()) { movie, genre ->
            movie.results.map {
                it.copy().toMovie(genre)
            }
        }
}
