package com.khrystynasika.movievision

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khrystynasika.movievision.home.HomeScreen
import com.khrystynasika.movievision.theme.MovieVisionTheme

@Composable
fun App() {
    MovieVisionTheme {
        val navController = rememberNavController()

        fun navigateTo(destination: NavigationDestination) {
            navController.navigate(destination.route)
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
                    // TODO add screen
                    Text(text = "Browse all screen")
                }
            }
        }
    }
}
