package com.khrystynasika.movievision.movies.watch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khrystynasika.movievision.movies.domain.Movie
import com.seiko.imageloader.rememberImagePainter
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.ic_star
import movievision.composeapp.generated.resources.movie_rating
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BrowseAllMoviesList(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onMovieDetailsClicked: (Int) -> Unit,

    ) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(movies, key = { it.id }) { item ->
            BrowseAllItem(movie = item, onClick = { onMovieDetailsClicked(item.id) })
        }
    }

}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun BrowseAllItem(
    modifier: Modifier = Modifier, movie: Movie, onClick: () -> Unit
) {
    val painter = rememberImagePainter(movie.backImage)
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = remember(sizeImage) {
        Brush.verticalGradient(
            colors = listOf(Color.Transparent, Color.Black),
            startY = sizeImage.height.toFloat() / 3,
            endY = sizeImage.height.toFloat(),
        )
    }

    Box(
        modifier = modifier, contentAlignment = Alignment.BottomStart
    ) {
        Box(modifier = modifier.clip(RoundedCornerShape(10.dp))) {
            Image(
                modifier = modifier.aspectRatio(12f / 7f).clickable { onClick() }.onGloballyPositioned {
                        sizeImage = it.size
                    },
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
            )
            Box(
                modifier = Modifier.matchParentSize().background(gradient)
            )
        }

        Row(
            modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = modifier.weight(5f)
            ) {
                Text(
                    text = movie.title,
                    fontSize = 32.sp,
                    color = Color.White,
                )

                Text(
                    modifier = modifier.padding(bottom = 8.dp),
                    text = movie.genres.joinToString { it },
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }

            Spacer(
                Modifier.weight(0.5f).fillMaxHeight().background(Color.Green)
            )
            Column(
                modifier = modifier.weight(1f)
            ) {
                Image(
                    painterResource(Res.drawable.ic_star),
                    modifier = modifier.height(30.dp).width(30.dp).align(Alignment.CenterHorizontally),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(color = Color(0xFFFCC419))
                )
                Text(
                    modifier = modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                    fontSize = 16.sp,
                    text = stringResource(
                        Res.string.movie_rating, movie.rating
                    ),
                    color = Color.White
                )

            }
        }
    }
}