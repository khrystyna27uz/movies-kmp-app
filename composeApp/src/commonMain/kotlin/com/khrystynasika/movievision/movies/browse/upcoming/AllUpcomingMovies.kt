package com.khrystynasika.movievision.movies.browse.upcoming

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khrystynasika.movievision.core.koinViewModel
import com.khrystynasika.movievision.movies.watch.AllUpcomingMoviesViewModel
import com.khrystynasika.movievision.browseall.BrowseAllMoviesList

@Composable
fun AllUpcomingMovies(
    modifier: Modifier = Modifier,
    onMovieDetailsClicked: (Int) -> Unit,
) {

    val viewModel: AllUpcomingMoviesViewModel = koinViewModel()

    BrowseAllMoviesList(
        modifier = modifier,
        movies = viewModel.movies.value,
        onMovieDetailsClicked = onMovieDetailsClicked
    )

}