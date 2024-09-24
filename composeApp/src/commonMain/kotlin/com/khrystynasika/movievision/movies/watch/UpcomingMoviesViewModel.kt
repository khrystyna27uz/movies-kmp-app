package com.khrystynasika.movievision.movies.watch

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UpcomingMoviesViewModel(
    repository: MoviesRepository
) : ViewModel() {

    // TODO add pagination
    private val page = 1

    private val _upcoming = mutableStateOf<List<Movie>>(emptyList())
    val upcoming: State<List<Movie>> = _upcoming

    init {
        repository.getUpcoming(page)
            .onEach {
                _upcoming.value = it
            }
            .launchIn(viewModelScope)
    }
}