package com.khrystynasika.movievision.theme

import androidx.compose.runtime.Composable

@Composable
expect fun MovieVisionTheme(
    content: @Composable () -> Unit
)

@Composable
expect fun PreviewTheme(
    content: @Composable () -> Unit
)