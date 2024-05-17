package com.khrystynasika.movievision.movies.data

import com.khrystynasika.movievision.movies.domain.FullCast
import com.khrystynasika.movievision.movies.domain.IMDBRating
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MovieDetails
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import com.khrystynasika.movievision.movies.domain.Review
import com.khrystynasika.movievision.movies.domain.Trailer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlin.time.Duration

class MoviesRepositoryImpl : MoviesRepository {

    override fun getMovies(): Flow<List<Movie>> =
        flowOf(moviesList)

    override fun getUpcoming(): Flow<List<Movie>> =
        flowOf(upcomingList)

    override fun getMovieById(movieId: String): Flow<Movie> =
        flowOf(moviesList.first { it.id == movieId })

    override fun getMovieDetailsById(movieId: String): Flow<MovieDetails> =
        getMovieById(movieId)
            .map { movie ->
                MovieDetails(
                    movie = movie,
                    fullCast = fullCast,
                    review = review,
                    trailer = trailer,
                    poster = poster,
                )
            }
}

private val upcomingList: List<Movie> = listOf(
    Movie(
        id = "tt9362867686722",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt936286868678722",
        title = "Fast X",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BNzZmOTU1ZTEtYzVhNi00NzQxLWI5ZjAtNWNhNjEwY2E3YmZjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt93686868686627980822",
        title = "John Wick: Chapter 4",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
)

private val moviesList: List<Movie> = listOf(
    Movie(
        id = "tt9362uhuh722",
        title = "Spider-Man",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt5971474",
        title = "The Little Mermaid",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt3291150",
        title = "Expend4bles",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMjkwNWU2NjQtODVjNS00ZDg1LThkODEtM2RkYTYwYjBkZTA2XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt936uhu2722",
        title = "Spider-Man: Into the Spider-Verse",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMjMwNDkxMTgzOF5BMl5BanBnXkFtZTgwNTkwNTQ3NjM@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt93uhuh62722",
        title = "The Flash",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMDY0MGJlYzktNzZiNS00MWZhLWJjNWEtNmJmZTg3NjMwZDYwXkEyXkFqcGdeQXVyMTUzOTcyODA5._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt9362722",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt936278722",
        title = "Fast X",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BNzZmOTU1ZTEtYzVhNi00NzQxLWI5ZjAtNWNhNjEwY2E3YmZjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt93627980822",
        title = "John Wick: Chapter 4",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEwXkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt93",
        title = "Guardians of the Galaxy Vol. 3",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BMDgxOTdjMzYtZGQxMS00ZTAzLWI4Y2UtMTQzN2VlYjYyZWRiXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt93627",
        title = "Spider-Man: Across the Spider-Verse",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BNzQ1ODUzYjktMzRiMS00ODNiLWI4NzQtOTRiN2VlNTNmODFjXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt59714",
        title = "The Little Mermaid",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYTUxYjczMWUtYzlkZC00NTcwLWE3ODQtN2I2YTIxOTU0ZTljXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_Ratio0.6716_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "6767",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt962722",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt936766654t2722",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
    Movie(
        id = "tt22",
        title = "Avatar: The Way of Water",
        year = 2023f,
        image = "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMxXkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_Ratio0.7015_AL_.jpg",
        genres = listOf("Action", "Adventure", "Fantasy"),
        rating = IMDBRating(rating = 3f, count = 100),
        contentRating = "12+",
        duration = Duration.ZERO
    ),
)

private val fullCast: FullCast = FullCast(
    directors = listOf(
        FullCast.Director(
            job = "director",
            name = "John Cameron",
            description = "director"
        )
    ),
    actors = listOf(
        FullCast.Actor(
            image = "https://m.media-amazon.com/images/M/MV5BMDdjYjI1NGMtOGExOC00NjA0LTg2YmYtNGRjNzU4MGE4MDBhXkEyXkFqcGdeQXVyMzI5NDcxNzI@._V1_Ratio0.7727_AL_.jpg",
            name = "Alfred Abel",
            role = "Johann (Joh) Fredersen"
        ),
        FullCast.Actor(
            image = "https://m.media-amazon.com/images/M/MV5BMjAzMzcyODI2NF5BMl5BanBnXkFtZTcwNDY4NjgyMw@@._V1_Ratio1.2727_AL_.jpg",
            name = "Gustav Fröhlich",
            role = "Johann (Joh) Fredersen"
        ),
        FullCast.Actor(
            image = "https://m.media-amazon.com/images/M/MV5BMDdjYjI1NGMtOGExOC00NjA0LTg2YmYtNGRjNzU4MGE4MDBhXkEyXkFqcGdeQXVyMzI5NDcxNzI@._V1_Ratio0.7727_AL_.jpg",
            name = "Alfred Abel",
            role = "Johann (Joh) Fredersen"
        ),
        FullCast.Actor(
            image = "https://m.media-amazon.com/images/M/MV5BMTY1ODgzMzU3OV5BMl5BanBnXkFtZTgwMTQ3ODMwMzE@._V1_Ratio0.7273_AL_.jpg",
            name = "Rudolf Klein-Rogge",
            role = "Johann (Joh) Fredersen"
        ),
        FullCast.Actor(
            image = "https://m.media-amazon.com/images/M/MV5BYmZhYWVkYzgtMTBkYi00OWFlLWI3ZjAtN2E5N2VmZDEyNWNjXkEyXkFqcGdeQXVyMzI5NDcxNzI@._V1_Ratio0.8182_AL_.jpg",
            name = "Theodor Loos",
            role = "Johann (Joh) Fredersen"
        ),
    )
)

private val review: Review = Review(
    username = "claudio_carvalho",
    helpful = Review.Helpful(positive = 12, total = 2324),
    title = "Heart is the Mediator Between Brains and Muscles - A Futuristic View of the Fight of Classes",
    content = "In the future, the society of Metropolis is divided in two social classes: the workers, who live in the underground below the machines level, and the dominant classes that lives on the surface. The workers are controlled by their leader Maria (Brigitte Helm), who wants to find a mediator between the upper class lords and the workers, since she believes that a heart would be necessary between brains and muscles"
)

private val trailer: Trailer = Trailer(
    title = "The Kid",
    videoUrl = "https://www.youtube.com/watch?v=KnWJepe-nxE",
    thumbnailUrl = "https://media-cache.cinematerial.com/p/500x/1tjlgd4z/no-hard-feelings-movie-poster.jpg?v=1682342077",
    duration = Duration.ZERO,
)

private const val poster: String =
    "https://media-cache.cinematerial.com/p/500x/1tjlgd4z/no-hard-feelings-movie-poster.jpg?v=1682342077"
