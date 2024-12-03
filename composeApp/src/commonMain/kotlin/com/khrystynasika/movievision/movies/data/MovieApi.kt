package com.khrystynasika.movievision.movies.data

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow

const val IMAGE_PATH_PART = "https://image.tmdb.org/t/p/w500/"

internal interface MovieApi {

    // TODO manage max and min release_date
    @GET("3/discover/movie")
    fun getMovies(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_release_type") withReleaseType: String = "2|3",
        @Query("release_date.gte") minReleaseDate: String = "2016-06-20",
        @Query("release_date.lte") maxReleaseDate: String = "2024-05-23"
    ): Flow<MovieResult>

    @GET("3/movie/upcoming?page=1")
    fun getMoviesUpcoming(): Flow<MovieResult>

    // TODO manage max and min release_date (min 2 months from now, max - today)
    @GET("3/discover/movie")
    fun getMoviesNowPlaying(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_release_type") withReleaseType: String = "2|3",
        @Query("release_date.gte") minReleaseDate: String = "2024-09-04",
        @Query("release_date.lte") maxReleaseDate: String = "2024-10-16"
    ): Flow<MovieResult>

    // TODO manage max and min release_date, min - start of last year, max - end of last year
    //  + see check if only last year firms present
    @GET("3/discover/movie")
    fun getMoviesPastYear(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("with_release_type") withReleaseType: String = "2|3",
        @Query("release_date.gte") minReleaseDate: String = "2023-01-01",
        @Query("release_date.lte") maxReleaseDate: String = "2024-01-01"
    ): Flow<MovieResult>

    @GET("3/discover/movie")
    fun getMoviesPopular(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("sort_by") sortBy: String = "popularity.desc",
    ): Flow<MovieResult>

    @GET("3/discover/movie")
    fun getMoviesTopRated(
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
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
        @Query("page") page: Int = 1,
        @Query("query") query: String
    ): Flow<MovieResult>
}


