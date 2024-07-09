package com.example.identityproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = LightPrimaryBrandColor,
    onPrimary = DarkPrimaryWhiteColor,
    secondary = LightSecondaryBrandColor,
    onSecondary = DarkTernaryWhiteColor,
    background = DarkBackground,
    onBackground = DarkSecondaryWhiteColor,
    surface = DarkCardColor,
    onSurface = DarkSecondaryWhiteColor
)

private val LightColorScheme = lightColorScheme(
    primary = LightPrimaryBrandColor,
    onPrimary = LightPrimaryBlackColor,
    secondary = LightSecondaryBrandColor,
    onSecondary = LightSecondaryBlackColor,
    background = LightBackground,
    onBackground = LightSecondaryBlackColor,
    surface = WhiteColor,
    onSurface = LightSecondaryBlackColor
)

@Composable
fun IdentityProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}