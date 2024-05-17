package com.khrystynasika.movievision.movies.upcoming

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khrystynasika.movievision.movies.watch.MovieList

@Composable
fun UpcomingMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: UpcomingMoviesViewModel = viewModel(),
    onBrowseMoviesClicked: () -> Unit,
    onMovieDetailsClicked: (String) -> Unit,
) {
    MovieList(
        modifier = modifier,
        movies = viewModel.upcoming.value,
        onBrowseMoviesClicked = onBrowseMoviesClicked,
        onMovieItemClicked = onMovieDetailsClicked,
    )
}