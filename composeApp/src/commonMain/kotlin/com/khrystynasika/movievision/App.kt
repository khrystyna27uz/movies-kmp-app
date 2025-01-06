package com.khrystynasika.movievision

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khrystynasika.movievision.di.appModule
import com.khrystynasika.movievision.di.networkModule
import com.khrystynasika.movievision.discover.browse.BrowseMoviesScreen
import com.khrystynasika.movievision.home.HomeScreen
import com.khrystynasika.movievision.movies.browse.BrowseAllScreen
import com.khrystynasika.movievision.movies.moviesModule
import com.khrystynasika.movievision.movies.details.MoviesDetailsScreen
import com.khrystynasika.movievision.theme.MovieVisionTheme
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = {
        modules(
            appModule,
            moviesModule,
            networkModule,
        )
    }) {
        MovieVisionTheme {
            val navController = rememberNavController()

            fun navigateTo(destination: String) {
                navController.navigate(destination)
            }

            Surface(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = NavigationDestination.Home.route,
                ) {
                    composable(NavigationDestination.Home.route) {
                        HomeScreen(navigateTo = ::navigateTo)
                    }
                    composable(NavigationDestination.BrowseAll.route) {
                        BrowseAllScreen(onMovieDetailsClicked = {
                            navigateTo(
                                NavigationDestination.MovieDetails.route(
                                    it
                                )
                            )
                        })
                    }
                    composable(NavigationDestination.MovieDetails.route) {
                        MoviesDetailsScreen()
                    }

                    composable(NavigationDestination.BrowseMovies.route) {
                        BrowseMoviesScreen(
                            onBackClicked = {
                                navController.navigateUp()
                            },
                            onMovieDetailsClicked = {
                                navigateTo(
                                    NavigationDestination.MovieDetails.route(
                                        it
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
