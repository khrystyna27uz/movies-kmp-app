@file:OptIn(ExperimentalResourceApi::class)

package com.khrystynasika.movievision.movies.watch

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.khrystynasika.movievision.movies.domain.Movie
import com.seiko.imageloader.rememberImagePainter
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.browse_all_movies
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onBrowseMoviesClicked: () -> Unit,
    onMovieItemClicked: (Int) -> Unit,
) {
    val columnsCount = 3
    LazyVerticalGrid(
        columns = GridCells.Fixed(columnsCount),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(movies, key = { it.id }) { item ->
            MovieItem(
                movie = item,
                onClick = { onMovieItemClicked(item.id) },
            )
        }
        item(span = { GridItemSpan(columnsCount) }) {
            Box {
                FooterButton(
                    modifier = Modifier
                        .align(Alignment.Center),
                    onClick = onBrowseMoviesClicked
                )
            }
        }
    }
}

@Composable
private fun FooterButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = stringResource(Res.string.browse_all_movies))
    }
}

@Composable
private fun MovieItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onClick: () -> Unit
) {
    val painter = rememberImagePainter(movie.image)
    Image(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .aspectRatio(9f / 12f)
            .clickable { onClick() },
        painter = painter,
        contentDescription = movie.title,
        contentScale = ContentScale.FillBounds,
    )
}
