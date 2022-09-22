package com.greentowersolution.driptap.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = ITBlue,
    primaryVariant = ITDarkBlue,
    secondary = ITBlue
)

private val LightColorPalette = lightColors(
    primary = ITBlue,
    primaryVariant = ITDarkBlue,
    secondary = ITBlue,
    background = ITBackground
)

@Composable
fun DripTapTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = if (darkTheme) Color.Black else ITDarkBlue

    SideEffect {
        systemUiController.setStatusBarColor(color = statusBarColor)
    }

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}