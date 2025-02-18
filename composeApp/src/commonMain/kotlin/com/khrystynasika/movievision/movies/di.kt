package com.khrystynasika.movievision.movies

import com.khrystynasika.movievision.movies.upcoming.UpcomingMoviesViewModel
import com.khrystynasika.movievision.movies.details.MoviesDetailsViewModel
import com.khrystynasika.movievision.movies.watch.WatchMoviesViewModel
import com.khrystynasika.movievision.movies.watch.AllWatchMoviesViewModel
import com.khrystynasika.movievision.movies.upcoming.AllUpcomingMoviesViewModel
import com.khrystynasika.movievision.discover.main.DiscoverViewModel
import com.khrystynasika.movievision.discover.browse.BrowseMoviesViewModel
import com.khrystynasika.movievision.profile.ProfileViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val moviesModule = module {
    factoryOf(::WatchMoviesViewModel)
    factoryOf(::MoviesDetailsViewModel)
    factoryOf(::UpcomingMoviesViewModel)
    factoryOf(::AllWatchMoviesViewModel)
    factoryOf(::AllUpcomingMoviesViewModel)
    factoryOf(::DiscoverViewModel)
    factoryOf(::BrowseMoviesViewModel)
    factoryOf(::ProfileViewModel)
}