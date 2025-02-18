package com.khrystynasika.movievision.core

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.compose.getKoin
import org.koin.core.parameter.parametersOf

@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val koin = getKoin()
    return viewModel {
        val savedStateHandle = createSavedStateHandle()
        koin.get(parameters = { parametersOf(savedStateHandle) })
    }
}