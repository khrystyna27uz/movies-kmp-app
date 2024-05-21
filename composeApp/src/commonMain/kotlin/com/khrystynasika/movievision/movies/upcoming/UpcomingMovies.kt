package com.khrystynasika.movievision.movies.upcoming

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khrystynasika.movievision.movies.watch.MovieList
import org.koin.compose.koinInject

@Composable
fun UpcomingMoviesScreen(
    modifier: Modifier = Modifier,
    onBrowseMoviesClicked: () -> Unit,
    onMovieDetailsClicked: (String) -> Unit,

    ) {

    val viewModel: UpcomingMoviesViewModel = koinInject()

    MovieList(
        modifier = modifier,
        movies = viewModel.upcoming.value,
        onBrowseMoviesClicked = onBrowseMoviesClicked,
        onMovieItemClicked = onMovieDetailsClicked,
    )
}