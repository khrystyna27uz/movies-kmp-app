package com.khrystynasika.movievision.movies.data

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow

const val IMAGE_PATH_PART = "https://image.tmdb.org/t/p/w500/"

internal interface MovieApi {

    @GET("3/discover/movie")
    fun getMovies(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_release_type") withReleaseType: String = "2|3",
        @Query("release_date.gte") minReleaseDate: String,
        @Query("release_date.lte") maxReleaseDate: String,
    ): Flow<MovieResult>

    @GET("3/movie/upcoming")
    fun getMoviesUpcoming(
        @Query("page") page: Int,
        @Query("with_release_type") withReleaseType: String = "2|3",
        @Query("release_date.gte") minReleaseDate: String,
    ): Flow<MovieResult>

    // TODO manage max and min release_date (min 2 months from now, max - today)
    @GET("3/discover/movie")
    fun getMoviesNowPlaying(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_release_type") withReleaseType: String = "2|3",
        @Query("release_date.gte") minReleaseDate: String,
        @Query("release_date.lte") maxReleaseDate: String,
    ): Flow<MovieResult>

    @GET("3/discover/movie")
    fun getMoviesPastYear(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_release_type") withReleaseType: String = "2|3",
        @Query("release_date.gte") minReleaseDate: String,
        @Query("release_date.lte") maxReleaseDate: String,
    ): Flow<MovieResult>

    @GET("3/discover/movie")
    fun getMoviesPopular(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "popularity.desc",
    ): Flow<MovieResult>

    @GET("3/discover/movie")
    fun getMoviesTopRated(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "vote_average.desc",
        @Query("vote_count.gte") voteCountGte: Int = 200
    ): Flow<MovieResult>

    @GET("3/movie/{id}")
    fun getMovieById(@Path("id") id: Int): Flow<MovieDetailsResult>

    @GET("3/movie/{id}/credits")
    fun getCastCrew(@Path("id") id: Int): Flow<MovieCastCrewResult>

    @GET("3/movie/{id}/videos")
    fun getTrailer(@Path("id") id: Int): Flow<TrailerResult>

    @GET("3/genre/movie/list")
    fun getGenres(): Flow<GenreResult>

    @GET("3/search/movie")
    fun getMoviesFromSearch(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("query") query: String
    ): Flow<MovieResult>
}