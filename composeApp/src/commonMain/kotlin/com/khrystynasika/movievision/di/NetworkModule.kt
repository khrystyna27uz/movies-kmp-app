package com.khrystynasika.movievision.di

import com.khrystynasika.movievision.movies.data.MovieApi
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.FlowConverterFactory
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module


private  const val baseUrl = "https://api.themoviedb.org/"

val networkModule = module {
    single { provideKtorFit() }
    single { provideAPi(get()) }
}

private fun provideKtorFit(): Ktorfit =
    ktorfit {
        baseUrl(baseUrl)
        httpClient(HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
            }
            defaultRequest {
                header(HttpHeaders.Accept, "application/json")
                header(
                    HttpHeaders.Authorization,
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNGQyNTFmZThjN2Q1NDVhNmUyODEyNzM5MzViM2QzYiIsInN1YiI6IjY2NGUyOTYwMzdmZDM0OWE5OGZkMTRmMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.xG2OOVVeFRVm9I-4ZhaG7DUb6OLgluGAcqY9Izz4_P0"
                )
            }
            install(Logging)
            {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        })
        converterFactories(
            FlowConverterFactory(),
            CallConverterFactory()
        )
    }

private fun provideAPi(ktorFit: Ktorfit): MovieApi =
    ktorFit.create()