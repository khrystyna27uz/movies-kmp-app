package com.khrystynasika.movievision.movies

import com.khrystynasika.movievision.movies.watch.UpcomingMoviesViewModel
import com.khrystynasika.movievision.movies.watch.MoviesDetailsViewModel
import com.khrystynasika.movievision.movies.watch.WatchMoviesViewModel
import com.khrystynasika.movievision.movies.watch.AllWatchMoviesViewModel
import com.khrystynasika.movievision.movies.watch.AllUpcomingMoviesViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val moviesModule = module {
    factoryOf(::WatchMoviesViewModel)
    factoryOf(::MoviesDetailsViewModel)
    factoryOf(::UpcomingMoviesViewModel)
    factoryOf(::AllWatchMoviesViewModel)
    factoryOf(::AllUpcomingMoviesViewModel)
}