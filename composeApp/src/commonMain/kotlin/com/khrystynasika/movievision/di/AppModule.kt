package com.khrystynasika.movievision.di

import com.khrystynasika.movievision.movies.data.MoviesRepositoryImpl
import com.khrystynasika.movievision.movies.domain.MoviesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::MoviesRepositoryImpl) bind MoviesRepository::class
}
