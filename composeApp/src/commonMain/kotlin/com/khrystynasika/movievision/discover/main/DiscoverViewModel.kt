package com.khrystynasika.movievision.discover.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khrystynasika.movievision.movies.domain.Movie
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DiscoverViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    // TODO add pagination
    private val page = 1

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _moviesNowPlaying = mutableStateOf<List<Movie>>(emptyList())
    val moviesNowPlaying: State<List<Movie>> = _moviesNowPlaying

    private val _moviesPastYear = mutableStateOf<List<Movie>>(emptyList())
    val moviesPastYear: State<List<Movie>> = _moviesPastYear

    private val _moviesPopular = mutableStateOf<List<Movie>>(emptyList())
    val moviesPopular: State<List<Movie>> = _moviesPopular

    private val _moviesTopRated = mutableStateOf<List<Movie>>(emptyList())
    val moviesTopRated: State<List<Movie>> = _moviesTopRated

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
        searchMovies(query = searchText.value)

    }

    fun onToggleSearch() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            _isSearching.value = false
        }
    }

    fun onSearchTextClose() {
        _searchText.value = ""
        _isSearching.value = false
    }

    // TODO find out why empty string doesn't work
    private fun searchMovies(query: String) {
        repository.getMoviesFromSearch(query = query, page = page)
            .onEach {
                _movies.value = it
            }
            .launchIn(viewModelScope)
    }

    init {
        repository.getMoviesNowPlaying(page = page)
            .onEach {
                _moviesNowPlaying.value = it
            }
            .launchIn(viewModelScope)

        repository.getMoviesPastYear(page = page)
            .onEach {
                _moviesPastYear.value = it
            }
            .launchIn(viewModelScope)

        repository.getMoviesPopular(page = page)
            .onEach {
                _moviesPopular.value = it
            }
            .launchIn(viewModelScope)

        repository.getMoviesTopRated(page = page)
            .onEach {
                _moviesTopRated.value = it
            }
            .launchIn(viewModelScope)
    }
}