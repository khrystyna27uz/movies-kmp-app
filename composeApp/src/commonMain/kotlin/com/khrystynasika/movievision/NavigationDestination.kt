package com.khrystynasika.movievision

import androidx.lifecycle.SavedStateHandle

sealed class NavigationDestination(val route: String) {
    data object Home : NavigationDestination("home")

    data object BrowseAll : NavigationDestination("browse_all")

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