package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MoviesRepositoryImpl : MoviesRepository {

    override fun getMovies(): Flow<List<Movie>> =
        flowOf(moviesList)
}

private val moviesList: List<Movie> = listOf(
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