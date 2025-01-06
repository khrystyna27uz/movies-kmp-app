@file:OptIn(ExperimentalResourceApi::class)

package com.khrystynasika.movievision.home

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.khrystynasika.movievision.NavigationDestination
import com.khrystynasika.movievision.discover.main.MainDiscoverScreen
import com.khrystynasika.movievision.movies.MovieTab
import com.khrystynasika.movievision.movies.TabScreen
import com.khrystynasika.movievision.movies.upcoming.UpcomingMoviesScreen
import com.khrystynasika.movievision.movies.watch.WatchMoviesScreen
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.bottom_navigation_discover
import movievision.composeapp.generated.resources.bottom_navigation_movies
import movievision.composeapp.generated.resources.bottom_navigation_profile
import movievision.composeapp.generated.resources.bottom_navigation_shows
import movievision.composeapp.generated.resources.movies_tab_upcoming
import movievision.composeapp.generated.resources.movies_tab_watch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen(
    navigateTo: (String) -> Unit,
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val items = bottomNavigationItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                items.forEach { navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = HomeNavigationDestination.Movies.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(HomeNavigationDestination.Movies.route) {
                TabScreen(
                    tabs = listOf(
                        MovieTab(
                            title = stringResource(resource = Res.string.movies_tab_watch),
                            content = {
                                WatchMoviesScreen(
                                    onBrowseMoviesClicked = {
                                        navigateTo(
                                            NavigationDestination.BrowseAll.route
                                        )
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
                        ),
                        MovieTab(
                            title = stringResource(resource = Res.string.movies_tab_upcoming),
                            content = {
                                UpcomingMoviesScreen(
                                    onBrowseMoviesClicked = { navigateTo(NavigationDestination.BrowseAll.route) },
                                    onMovieDetailsClicked = {
                                        navigateTo(
                                            NavigationDestination.MovieDetails.route(
                                                it
                                            )
                                        )
                                    })
                            },
                        )
                    )
                )
            }

            composable(HomeNavigationDestination.Shows.route) {
                // TODO version 2.0 add Show screen
            }

            composable(HomeNavigationDestination.Discover.route) {
                MainDiscoverScreen(
                    onMovieDetailsClicked = {
                        navigateTo(
                            NavigationDestination.MovieDetails.route(
                                it
                            )
                        )
                    },
                    onBrowseMoviesClicked = {
                        navigateTo(
                            NavigationDestination.BrowseMovies.route(
                                it
                            )
                        )
                    }
                )
            }
            composable(HomeNavigationDestination.Profile.route) {

            }
        }
    }
}

private data class BottomNavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
)

private sealed class HomeNavigationDestination(val route: String) {
    data object Movies : HomeNavigationDestination("movie_route")
    data object Shows : HomeNavigationDestination("shows_route")
    data object Discover : HomeNavigationDestination("discover_route")
    data object Profile : HomeNavigationDestination("profile_route")
}

@Composable
private fun bottomNavigationItems(): List<BottomNavigationItem> = listOf(
    BottomNavigationItem(
        label = stringResource(Res.string.bottom_navigation_movies),
        icon = Icons.Filled.Home,
        route = HomeNavigationDestination.Movies.route
    ),
    BottomNavigationItem(
        label = stringResource(Res.string.bottom_navigation_shows),
        icon = Icons.Filled.Person,
        route = HomeNavigationDestination.Shows.route
    ),
    BottomNavigationItem(
        label = stringResource(Res.string.bottom_navigation_discover),
        icon = Icons.Filled.Search,
        route = HomeNavigationDestination.Discover.route
    ),
    BottomNavigationItem(
        label = stringResource(Res.string.bottom_navigation_profile),
        icon = Icons.Filled.Person,
        route = HomeNavigationDestination.Profile.route
    ),
)