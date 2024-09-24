package com.khrystynasika.movievision.movies.browse.watch

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khrystynasika.movievision.core.koinViewModel
import com.khrystynasika.movievision.movies.watch.AllWatchMoviesViewModel
import com.khrystynasika.movievision.movies.watch.BrowseAllMoviesList

@Composable
fun AllWatchMovie(
    modifier: Modifier = Modifier,
    onMovieDetailsClicked: (Int) -> Unit,
) {
    val viewModel: AllWatchMoviesViewModel = koinViewModel()

    BrowseAllMoviesList(
        modifier = modifier,
        movies = viewModel.movies.value,
        onMovieDetailsClicked = onMovieDetailsClicked
    )

}

