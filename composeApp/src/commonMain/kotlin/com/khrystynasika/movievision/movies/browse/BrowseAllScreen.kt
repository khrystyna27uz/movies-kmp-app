@file:OptIn(ExperimentalResourceApi::class)

package com.khrystynasika.movievision.movies.browse

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khrystynasika.movievision.movies.MovieTab
import com.khrystynasika.movievision.movies.TabScreen
import com.khrystynasika.movievision.movies.browse.upcoming.AllUpcomingMovies
import com.khrystynasika.movievision.movies.browse.watch.AllWatchMovie
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.movies_tab_upcoming
import movievision.composeapp.generated.resources.movies_tab_watch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@Composable
fun BrowseAllScreen(
    modifier: Modifier = Modifier,
    onMovieDetailsClicked: (Int) -> Unit,
) {
    TabScreen(
        modifier = modifier,
        tabs = listOf(
            MovieTab(
                title = stringResource(resource = Res.string.movies_tab_watch),
                content = { AllWatchMovie(onMovieDetailsClicked = onMovieDetailsClicked) },
            ),
            MovieTab(
                title = stringResource(resource = Res.string.movies_tab_upcoming),
                content = { AllUpcomingMovies(onMovieDetailsClicked = onMovieDetailsClicked) },
            ),
        ),
    )
}