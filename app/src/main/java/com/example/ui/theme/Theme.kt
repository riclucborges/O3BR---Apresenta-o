package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val O3brDarkColorScheme = darkColorScheme(
    primary = O3brElectricCyan,
    onPrimary = Color(0xFF002020),
    primaryContainer = O3brCyanContainer,
    onPrimaryContainer = O3brOnCyanContainer,
    secondary = O3brBrightCyan,
    onSecondary = Color(0xFF002020),
    background = O3brBackground,
    onBackground = O3brOnSurface,
    surface = O3brBackground,
    onSurface = O3brOnSurface,
    surfaceVariant = O3brSurfaceHighest,
    onSurfaceVariant = O3brOnSurfaceVariant,
    outline = O3brOutline,
    outlineVariant = O3brOutlineVariant,
    surfaceContainerLow = O3brSurfaceLow,
    surfaceContainer = O3brSurface,
    surfaceContainerHigh = O3brSurfaceHigh,
    surfaceContainerHighest = O3brSurfaceHighest
)

@Composable
fun O3brTheme(
    darkTheme: Boolean = true, // Force futuristic high-contrast dark theme by default
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = O3brDarkColorScheme,
        typography = Typography,
        content = content
    )
}
