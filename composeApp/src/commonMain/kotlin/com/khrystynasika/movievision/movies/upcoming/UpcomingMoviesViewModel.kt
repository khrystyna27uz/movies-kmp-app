package com.khrystynasika.movievision.movies.upcoming

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khrystynasika.movievision.movies.data.MoviesRepositoryImpl
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class UpcomingMoviesViewModel : ViewModel() {

    private val repository: MoviesRepository = MoviesRepositoryImpl()

    private val _upcoming = mutableStateOf<List<Movie>>(emptyList())
    val upcoming: State<List<Movie>> = _upcoming

    init {
        repository.getUpcoming()
            .onEach {
                _upcoming.value = it
            }
            .launchIn(viewModelScope)
    }
}