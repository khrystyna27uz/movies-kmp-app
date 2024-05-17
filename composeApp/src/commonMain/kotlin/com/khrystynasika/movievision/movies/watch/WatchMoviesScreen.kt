package com.khrystynasika.movievision.movies.watch

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WatchMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: MoviesViewModel = viewModel(),
    onBrowseMoviesClicked: () -> Unit,
    onMovieDetailsClicked: (String) -> Unit,
) {
    MovieList(
        modifier = modifier,
        movies = viewModel.movies.value,
        onBrowseMoviesClicked = onBrowseMoviesClicked,
        onMovieItemClicked = onMovieDetailsClicked,
    )
}