package com.khrystynasika.movievision.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable

@Composable
actual fun MovieVisionTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
actual fun PreviewTheme(
    content: @Composable () -> Unit
) {
    MovieVisionTheme(
        content = content
    )
}