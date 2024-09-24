@file:OptIn(ExperimentalResourceApi::class, ExperimentalResourceApi::class)

package com.khrystynasika.movievision.movies.watch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khrystynasika.movievision.core.koinViewModel
import com.khrystynasika.movievision.movies.domain.FullCast
import com.khrystynasika.movievision.movies.domain.MovieDetails
import com.seiko.imageloader.rememberImagePainter
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.cast_and_crew
import movievision.composeapp.generated.resources.ic_star
import movievision.composeapp.generated.resources.movie_rating
import movievision.composeapp.generated.resources.movie_watch_type
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MoviesDetailsScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: MoviesDetailsViewModel = koinViewModel()

    val uriHandler = LocalUriHandler.current

    val details = viewModel.details.collectAsState().value ?: return

    Box(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 12.dp)
        ) {
            Header(movieDetails = details)
            DetailsView(
                details = details,
                onTrailerClicked = { uriHandler.openUri(it) },
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun Header(
    modifier: Modifier = Modifier,
    movieDetails: MovieDetails,
) {
    val painter = rememberImagePainter(movieDetails.movie.image)
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = remember(sizeImage) {
        Brush.verticalGradient(
            colors = listOf(Color.Transparent, Color.Black),
            startY = sizeImage.height.toFloat() / 3,
            endY = sizeImage.height.toFloat()
        )
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        Box {
            Image(
                modifier = modifier.aspectRatio(12f / 8f)
                    .onGloballyPositioned {
                        sizeImage = it.size
                    },
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
            )
            Box(
                modifier = Modifier.matchParentSize()
                    .background(gradient)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = modifier
                    .weight(5f)
            ) {
                Text(
                    text = movieDetails.movie.title,
                    fontSize = 32.sp,
                    color = Color.White,
                )

                Text(
                    modifier = modifier
                        .padding(bottom = 8.dp),
                    text = movieDetails.movie.year,
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }

            Spacer(
                Modifier.weight(0.5f).fillMaxHeight().background(Color.Green)
            )
            Column(
                modifier = modifier
                    .weight(1f)
            ) {
                Image(
                    painterResource(Res.drawable.ic_star),
                    modifier = modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(Alignment.CenterHorizontally),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(color = Color(0xFFFCC419))
                )
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    fontSize = 16.sp,
                    text = stringResource(
                        Res.string.movie_rating,
                        movieDetails.movie.rating
                    ),
                    color = Color.White
                )

            }
        }
    }
}

@Composable
private fun DetailsView(
    modifier: Modifier = Modifier,
    details: MovieDetails,
    onTrailerClicked: (url: String) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        GenreList(
            genres = details.movie.genres
        )
        ContentView(details = details)
        HorizontalDivider(thickness = 1.dp)

        TrailerView(
            details = details,
            onClick = onTrailerClicked
        )

        HorizontalDivider(thickness = 1.dp)
    }
    Text(
        stringResource(Res.string.cast_and_crew),
        fontSize = 22.sp,
        modifier = Modifier
            .padding(start = 12.dp, top = 12.dp),
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Normal,
    )
    CastCrewList(fullCast = details.fullCast)
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
            OutlinedButton(onClick = {}) {
                Text(text = genre)
            }
        }
    }
}

@Composable
private fun ContentView(
    modifier: Modifier = Modifier,
    details: MovieDetails,
) {
    Column(
        modifier = modifier
            .padding(top = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
        }
        Text(
            details.movie.overview,
            modifier = modifier
                .padding(bottom = 12.dp)
        )

        Box(
            modifier = modifier
                .align(Alignment.End)
        ) {
            Text(
                text = details.movie.tagline,
                fontStyle = FontStyle.Italic,
                modifier = modifier.padding(bottom = 12.dp)
            )
        }


    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun TrailerView(
    modifier: Modifier = Modifier,
    details: MovieDetails,
    onClick: (String) -> Unit
) {
    if (details.trailer.videoUrl == null ||
        details.trailer.title == null ||
        details.trailer.type == null
    ) return
    val painter = rememberImagePainter(url = details.movie.image)

    Row(
        modifier = modifier.padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = modifier
                    .clip(RoundedCornerShape(4.dp))
                    .size(
                        width = 180.dp,
                        height = 100.dp
                    )
                    .clickable { onClick(details.trailer.videoUrl) },
                painter = painter,
                contentDescription = details.trailer.title,
                contentScale = ContentScale.FillBounds,
            )
            Image(
                imageVector = Icons.Filled.PlayArrow,
                modifier = modifier.height(30.dp).width(30.dp),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = Color.White)
            )
        }
        Column(
            modifier = modifier.padding(start = 12.dp)
        ) {
            Text(
                text = stringResource(Res.string.movie_watch_type, details.trailer.type),
                fontWeight = FontWeight.Medium
            )
            Text(details.trailer.title)
        }

    }
}

@Composable
private fun CastCrewList(
    modifier: Modifier = Modifier,
    fullCast: FullCast,
) {
    LazyRow(
        modifier = modifier
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            (CastCrewItem(
                photo = fullCast.director.image,
                name = fullCast.director.name,
                role = fullCast.director.job
            ))
        }
        items(fullCast.actors) { item ->
            CastCrewItem(
                photo = item.image,
                name = item.name,
                role = item.role
            )
        }
    }
}

@Composable
private fun CastCrewItem(
    modifier: Modifier = Modifier,
    photo: String?,
    name: String,
    role: String,
) {
    val painter = rememberImagePainter(
        url = photo.orEmpty(),
        placeholderPainter = { rememberVectorPainter(Icons.Filled.Person) },
        errorPainter = { rememberVectorPainter(Icons.Filled.Person) },
    )

    Column(
        modifier = modifier
            .width(88.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(88.dp)
                .clip(CircleShape)
        )

        Text(
            modifier = modifier
                .padding(top = 12.dp),
            text = name,
            maxLines = 2,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
        )
        Text(
            text = role,
            maxLines = 2,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
        )
    }
}