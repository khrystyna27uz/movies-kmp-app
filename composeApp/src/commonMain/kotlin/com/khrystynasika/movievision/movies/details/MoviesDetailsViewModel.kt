package com.khrystynasika.movievision.movies.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khrystynasika.movievision.NavigationDestination
import com.khrystynasika.movievision.movies.domain.MovieDetails
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MoviesDetailsViewModel(
    repository: MoviesRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val movieId: Int =
        NavigationDestination.MovieDetails.Arguments(savedStateHandle).movieId

    private val _details = MutableStateFlow<MovieDetails?>(null)
    val details: StateFlow<MovieDetails?> = this._details.asStateFlow()

    init {
        repository.getMovieDetailsById(movieId)
            .onEach { _details.value = it }
            .launchIn(viewModelScope)
    }

}