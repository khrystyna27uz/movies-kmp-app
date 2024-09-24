package com.khrystynasika.movievision.movies.data

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow

const val IMAGE_PATH_PART = "https://image.tmdb.org/t/p/w500/"

internal interface MovieApi {

    // TODO manage release_date
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

    @GET("3/movie/{id}")
    fun getMovieById(@Path("id") id: Int): Flow<MovieDetailsResult>

    @GET("3/movie/{id}/credits")
    fun getCastCrew(@Path("id") id: Int): Flow<MovieCastCrewResult>

    @GET("3/movie/{id}/videos")
    fun getTrailer(@Path("id") id: Int): Flow<TrailerResult>

    @GET("3/genre/movie/list")
    fun getGenres(): Flow<GenreResult>

}


