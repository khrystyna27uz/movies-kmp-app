@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)

package com.khrystynasika.movievision.discover.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khrystynasika.movievision.core.koinViewModel
import com.khrystynasika.movievision.discover.browse.MovieFilter
import com.khrystynasika.movievision.movies.domain.Movie
import com.seiko.imageloader.rememberImagePainter
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.discover_movie_now_playing
import movievision.composeapp.generated.resources.discover_movie_past_year
import movievision.composeapp.generated.resources.discover_movie_popular
import movievision.composeapp.generated.resources.discover_movie_search
import movievision.composeapp.generated.resources.discover_movie_top_rated
import movievision.composeapp.generated.resources.ic_star
import movievision.composeapp.generated.resources.movie_rating
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainDiscoverScreen(
    modifier: Modifier = Modifier,
    onMovieDetailsClicked: (Int) -> Unit,
    onBrowseMoviesClicked: (movieFilter: String) -> Unit,
) {

    val viewModel: DiscoverViewModel = koinViewModel()

    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    val movies by viewModel.movies.collectAsState()

    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            SearchBar(
                query = searchText,
                onQueryChange = viewModel::onSearchTextChange,
                onSearch = viewModel::onSearchTextChange,
                active = isSearching,
                onActiveChange = {
                    viewModel.onToggleSearch()
                },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = stringResource(resource = Res.string.discover_movie_search))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        Icon(Icons.Default.Close,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                viewModel.onSearchTextClose()
                                focusManager.clearFocus()
                            })
                    }
                },
            ) {
                LazyColumn {
                    items(movies) { movie ->
                        MovieSearchItem(
                            modifier = modifier,
                            movie = movie,
                            onMovieDetailsClicked = onMovieDetailsClicked
                        )
                    }
                }
            }
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            DiscoveryItem(
                modifier = Modifier.padding(innerPadding),
                movies = viewModel.moviesNowPlaying.value,
                title = stringResource(resource = Res.string.discover_movie_now_playing),
                onMovieDetailsClicked = onMovieDetailsClicked,
                onBrowseMoviesClicked = { onBrowseMoviesClicked(MovieFilter.NOW_PLAYING.name) },
            )

            DiscoveryItem(
                movies = viewModel.moviesPastYear.value,
                title = stringResource(resource = Res.string.discover_movie_past_year),
                onMovieDetailsClicked = onMovieDetailsClicked,
                onBrowseMoviesClicked = { onBrowseMoviesClicked(MovieFilter.PAST_YEAR.name) },
            )

            DiscoveryItem(
                movies = viewModel.moviesTopRated.value,
                title = stringResource(resource = Res.string.discover_movie_top_rated),
                onMovieDetailsClicked = onMovieDetailsClicked,
                onBrowseMoviesClicked = { onBrowseMoviesClicked(MovieFilter.TOP_RATED.name) },
            )

            DiscoveryItem(
                movies = viewModel.moviesPopular.value,
                title = stringResource(resource = Res.string.discover_movie_popular),
                onMovieDetailsClicked = onMovieDetailsClicked,
                onBrowseMoviesClicked = { onBrowseMoviesClicked(MovieFilter.POPULAR.name) },
            )
        }
    }
}


@Composable
fun DiscoveryItem(
    modifier: Modifier = Modifier,
    title: String,
    movies: List<Movie>,
    onMovieDetailsClicked: (Int) -> Unit,
    onBrowseMoviesClicked: () -> Unit,
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                maxLines = 1,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.clickable {
                    onBrowseMoviesClicked()
                },
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface),
                contentDescription = null
            )
        }

        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(movies) { item ->
                MovieItem(
                    movie = item,
                    onMovieDetailsClicked = onMovieDetailsClicked
                )
            }
        }
    }
}

@Composable
private fun MovieSearchItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieDetailsClicked: (Int) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(90.dp).clickable { onMovieDetailsClicked(movie.id) }

    ) {
        val painter = rememberImagePainter(movie.image)
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .aspectRatio(9f / 12f)
                .clickable { onMovieDetailsClicked(movie.id) },
            painter = painter,
            contentDescription = movie.title,
            contentScale = ContentScale.FillBounds,
        )

        Column(
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = movie.title,
                fontWeight = FontWeight.Medium
            )
            GenreList(
                genres = movie.genres
            )
        }

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(Res.drawable.ic_star),
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .align(Alignment.CenterHorizontally),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = Color(0xFFFCC419))
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 16.sp,
                text = stringResource(
                    Res.string.movie_rating,
                    movie.rating
                ),
            )

        }
    }

    HorizontalDivider()
}

@Composable
private fun GenreList(
    modifier: Modifier = Modifier,
    genres: List<String>,
) {
    LazyRow(
        modifier = modifier.padding(top = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(genres) { genre ->
            Text(text = genre)
        }
    }
}

@Composable
private fun MovieItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onMovieDetailsClicked: (Int) -> Unit,
) {
    val painter = rememberImagePainter(movie.image)
    Image(
        modifier = modifier
            .height(146.dp)
            .clip(RoundedCornerShape(4.dp))
            .aspectRatio(9f / 12f)
            .clickable { onMovieDetailsClicked(movie.id) },
        painter = painter,
        contentDescription = movie.title,
        contentScale = ContentScale.FillBounds,
    )
}
