package com.khrystynasika.movievision.movies.watch

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khrystynasika.movievision.core.koinViewModel

@Composable
fun WatchMoviesScreen(
    modifier: Modifier = Modifier,
    onBrowseMoviesClicked: () -> Unit,
    onMovieDetailsClicked: (Int) -> Unit,
) {
    val viewModel: WatchMoviesViewModel = koinViewModel()

    MovieList(
        modifier = modifier,
        movies = viewModel.movies.value,
        onBrowseMoviesClicked = onBrowseMoviesClicked,
        onMovieItemClicked = onMovieDetailsClicked,
    )
}