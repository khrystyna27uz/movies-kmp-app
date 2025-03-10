package com.khrystynasika.movievision.movies.watch

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AllWatchMoviesViewModel(
    repository: MoviesRepository
) : ViewModel() {

    // TODO add pagination
    private val page = 1

    private val _movies = mutableStateOf<List<Movie>>(emptyList())
    val movies: State<List<Movie>> = _movies

    init {
        repository.getBrowseAll(page)
            .onEach {
                _movies.value = it
            }
            .launchIn(viewModelScope)
    }
}