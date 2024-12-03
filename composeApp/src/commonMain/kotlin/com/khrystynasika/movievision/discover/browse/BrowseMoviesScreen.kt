@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)

package com.khrystynasika.movievision.discover.browse

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.khrystynasika.movievision.browseall.BrowseAllMoviesList
import com.khrystynasika.movievision.core.koinViewModel
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.discover_movie_details_back_button_description
import movievision.composeapp.generated.resources.discover_movie_now_playing
import movievision.composeapp.generated.resources.discover_movie_past_year
import movievision.composeapp.generated.resources.discover_movie_popular
import movievision.composeapp.generated.resources.discover_movie_top_rated
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@Composable
fun BrowseMoviesScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onMovieDetailsClicked: (Int) -> Unit,
) {
    val viewModel: BrowseMoviesViewModel = koinViewModel()

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = when (viewModel.movieFilter) {
                    MovieFilter.NOW_PLAYING.name -> {
                        stringResource(resource = Res.string.discover_movie_now_playing)
                    }

                    MovieFilter.PAST_YEAR.name -> {
                        stringResource(resource = Res.string.discover_movie_past_year)
                    }

                    MovieFilter.TOP_RATED.name -> {
                        stringResource(resource = Res.string.discover_movie_top_rated)
                    }

                    MovieFilter.POPULAR.name -> {
                        stringResource(resource = Res.string.discover_movie_popular)
                    }

                    else -> ""
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
            )
        }, navigationIcon = {
            IconButton(onClick = { onBackClicked() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = stringResource(resource = Res.string.discover_movie_details_back_button_description)
                )
            }
        })
    }, content = { innerPadding ->
        BrowseAllMoviesList(
            modifier = modifier.padding(innerPadding),
            movies = viewModel.movies.value,
            onMovieDetailsClicked = onMovieDetailsClicked
        )
    })
}