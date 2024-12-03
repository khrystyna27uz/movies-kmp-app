package com.khrystynasika.movievision

import androidx.lifecycle.SavedStateHandle

sealed class NavigationDestination(val route: String) {
    data object Home : NavigationDestination("home")

    data object BrowseAll : NavigationDestination("browse_all")

    data object BrowseMovies : NavigationDestination("browse_movies/{filter}") {
        fun route(filter: String): String = "browse_movies/$filter"

        data class Arguments(
            val filter: String
        ) {
            companion object {
                operator fun invoke(savedStateHandle: SavedStateHandle): Arguments = Arguments(
                    filter = savedStateHandle.get<String>("filter")!!.toString(),
                )
            }
        }
    }

    data object MovieDetails : NavigationDestination("movie_details/{id}") {
        fun route(movieId: Int): String = "movie_details/$movieId"

        data class Arguments(
            val movieId: Int
        ) {
            companion object {
                operator fun invoke(savedStateHandle: SavedStateHandle): Arguments = Arguments(
                    movieId = savedStateHandle.get<String>("id")!!.toInt(),
                )
            }
        }
    }
}