package com.example.trackmyhabbit.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


// Custom colors based on the screenshot's orange theme
val OrangePrimary = Color(0xFFFB6E52) // A vibrant orange
val OrangeDark = Color(0xFFE0523C)   // A darker orange
val OrangeLight = Color(0xFFFF9E80)  // A lighter orange
val TextPrimary = Color(0xFFFFFFFF)  // White text for contrast
val TextSecondary = Color(0xFFCCCCCC) // Light gray text
val BackgroundOrange = Color(0xFFFB6E52) // Main background color from image

private val DarkColorScheme = darkColorScheme(
    primary = OrangeLight,
    secondary = OrangeLight,
    tertiary = OrangeLight,
    background = OrangeDark,
    surface = OrangeDark,
    onPrimary = TextPrimary,
    onSecondary = TextPrimary,
    onTertiary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

private val LightColorScheme = lightColorScheme(
    primary = OrangePrimary,
    secondary = OrangePrimary,
    tertiary = OrangePrimary,
    background = BackgroundOrange, // Use the vibrant orange as background
    surface = BackgroundOrange,
    onPrimary = TextPrimary,
    onSecondary = TextPrimary,
    onTertiary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)


@Composable
fun TrackMyHabbitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if(!view.isInEditMode){
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}