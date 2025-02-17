package com.khrystynasika.movievision.discover.browse

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khrystynasika.movievision.NavigationDestination
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class BrowseMoviesViewModel(
    repository: MoviesRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    // TODO add pagination
    private val page = 1

    val movieFilter: String =
        NavigationDestination.BrowseMovies.Arguments(savedStateHandle).filter

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _title = mutableStateOf("")
    val title: State<String> = _title

    init {
        when (movieFilter) {
            MovieFilter.NOW_PLAYING.name -> {
                repository.getMoviesNowPlaying(page = page)
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }

            MovieFilter.PAST_YEAR.name -> {
                repository.getMoviesPastYear(page = page)
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }

            MovieFilter.TOP_RATED.name -> {
                repository.getMoviesTopRated(page = page)
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }

            MovieFilter.POPULAR.name -> {
                repository.getMoviesPopular(page = page)
                    .onEach { _movies.value = it }
                    .launchIn(viewModelScope)
            }
        }
    }
}