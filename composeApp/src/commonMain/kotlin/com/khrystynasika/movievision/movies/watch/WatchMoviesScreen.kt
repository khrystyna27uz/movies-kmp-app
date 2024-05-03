@file:OptIn(ExperimentalResourceApi::class)

package com.khrystynasika.movievision.movies.watch

import androidx.compose.foundation.Image
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.theme.PreviewTheme
import com.seiko.imageloader.rememberImagePainter
import movievision.composeapp.generated.resources.Res
import movievision.composeapp.generated.resources.browse_all_movies
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun WatchMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: MoviesViewModel = viewModel(),
    onBrowseMoviesClicked: () -> Unit,
) {
    MovieList(
        modifier = modifier,
        movies = viewModel.movies.value,
        onBrowseMoviesClicked = onBrowseMoviesClicked,
    )
}

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onBrowseMoviesClicked: () -> Unit,
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
            MovieItem(movie = item)
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
) {
    val painter = rememberImagePainter(movie.image)
    Image(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .aspectRatio(9f / 14f),
        painter = painter,
        contentDescription = movie.title,
        contentScale = ContentScale.FillBounds,
    )
}

@Preview
@Composable
private fun PreviewMoviesScreen() {
    PreviewTheme {
        MovieList(onBrowseMoviesClicked = {}, movies = previewMovies)
    }
}

private val previewMovies: List<Movie> = listOf(
    Movie(
        id = "tt9362uhuh722",
        title = "Spider-Man: Across the Spider-Verse",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 9.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt5971474",
        title = "The Little Mermaid",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 7.6f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt3291150",
        title = "Expend4bles",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMjkwNWU2NjQtODVjNS00ZDg1LThkODEtM2RkYTYwYjBkZTA2XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 9.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt936uhu2722",
        title = "Spider-Man: Into the Spider-Verse",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMjMwNDkxMTgzOF5BMl5BanBnXkFtZTgwNTkwNTQ3NjM@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 8.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt93uhuh62722",
        title = "The Flash",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMDY0MGJlYzktNzZiNS00MWZhLWJjNWEtNmJmZTg3NjMwZDYwXkEyXkFqcGdeQXVyMTUzOTcyODA5._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 9.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt9362722",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        imDbRating = 7.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt936278722",
        title = "Fast X",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BNzZmOTU1ZTEtYzVhNi00NzQxLWI5ZjAtNWNhNjEwY2E3YmZjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 9.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt93627980822",
        title = "John Wick: Chapter 4",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 9.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt93",
        title = "Guardians of the Galaxy Vol. 3",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMDgxOTdjMzYtZGQxMS00ZTAzLWI4Y2UtMTQzN2VlYjYyZWRiXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 9.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt93627",
        title = "Spider-Man: Across the Spider-Verse",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 9.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt59714",
        title = "The Little Mermaid",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        imDbRating = 7.6f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "6767",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        imDbRating = 7.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt962722",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        imDbRating = 7.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt936766654t2722",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        imDbRating = 7.0f,
        imDbRatingCount = 114173,
    ),
    Movie(
        id = "tt22",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        imDbRating = 7.0f,
        imDbRatingCount = 114173,
    ),
)