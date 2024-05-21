package com.khrystynasika.movievision.movies.watch

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

@Composable
fun WatchMoviesScreen(
    modifier: Modifier = Modifier,
    onBrowseMoviesClicked: () -> Unit,
    onMovieDetailsClicked: (String) -> Unit,
) {

    val viewModel: WatchMoviesViewModel = koinInject()

    MovieList(
        modifier = modifier,
        movies = viewModel.movies.value,
        onBrowseMoviesClicked = onBrowseMoviesClicked,
        onMovieItemClicked = onMovieDetailsClicked,
    )
}