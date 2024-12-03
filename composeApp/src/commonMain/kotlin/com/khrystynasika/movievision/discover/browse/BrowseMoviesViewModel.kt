package com.khrystynasika.movievision.discover.browse

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khrystynasika.movievision.NavigationDestination
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class BrowseMoviesViewModel(
    repository: MoviesRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val movieFilter: String =
        NavigationDestination.BrowseMovies.Arguments(savedStateHandle).filter

    private val _movies = mutableStateOf<List<Movie>>(emptyList())
    val movies: State<List<Movie>> = _movies

    private val _title = mutableStateOf<String>("")
    val title: State<String> = _title

    init {
        when (movieFilter) {
            MovieFilter.NOW_PLAYING.name -> {
                repository.getMoviesNowPlaying()
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }

            MovieFilter.PAST_YEAR.name -> {
                repository.getMoviesPastYear()
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }

            MovieFilter.TOP_RATED.name -> {
                repository.getMoviesTopRated()
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }

            MovieFilter.POPULAR.name -> {
                repository.getMoviesPopular()
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }
        }
    }
}