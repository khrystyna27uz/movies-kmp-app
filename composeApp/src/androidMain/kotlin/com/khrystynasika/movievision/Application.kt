package com.khrystynasika.movievision

import android.app.Application
import com.khrystynasika.movievision.movies.data.MoviesRepositoryImpl
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import com.khrystynasika.movievision.movies.upcoming.UpcomingMoviesViewModel
import com.khrystynasika.movievision.movies.watch.WatchMoviesViewModel
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

class Application : Application() {

    private fun appModule() = module {
        single<MoviesRepository> { MoviesRepositoryImpl() }
    }

    private val androidModule = module {

        //TODO resolve issue with SavedStateHandle injection
        //viewModel { MoviesDetailsViewModel(get(), get()) }

        viewModel {
            UpcomingMoviesViewModel(get())
        }

        viewModel {
            WatchMoviesViewModel(get())
        }

    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(appModule() + androidModule)
        }
    }
}