package com.nikasov.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.nikasov.design.AppShapes
import com.nikasov.design.AppTypography
import com.nikasov.design.Dimensions
import com.nikasov.design.Green600
import com.nikasov.design.Green700
import com.nikasov.design.LocalDimensions
import com.nikasov.design.Purple600
import com.nikasov.design.Purple700

val ColorScheme.isLight: Boolean get() = background.luminance() > 0.5f

//todo: Card colors, text colors, etc. should be defined in the theme

/** Divider */
val ColorScheme.dividerColor: Color @Composable get() = if (isLight) Green600 else Green700

val ColorScheme.AppCardColors: CardColors
    @Composable get() = CardDefaults.cardColors(
        containerColor = surface,
        contentColor = onSurface,
        disabledContainerColor = surfaceContainer,
        disabledContentColor = onSurface
    )

private val LightThemeColors = lightColorScheme(
    primary = Green600,
    onPrimary = Green700,
    secondary = Purple600,
    onSecondary = Purple700,
)

private val DarkThemeColors = lightColorScheme(
    primary = Green600,
    onPrimary = Green700,
    secondary = Purple600,
    onSecondary = Purple700,
)

object AppAlphaValues {
    const val DISABLED = 0.38f
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = DarkThemeColors.takeIf { darkTheme } ?: LightThemeColors
    CompositionLocalProvider(
        LocalDimensions provides Dimensions(),
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}

object PacasoTheme {
    val colorScheme: ColorScheme @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme
    val typography: Typography @Composable @ReadOnlyComposable get() = MaterialTheme.typography
    val shapes: Shapes @Composable @ReadOnlyComposable get() = MaterialTheme.shapes
    val dimensions: Dimensions @Composable @ReadOnlyComposable get() = LocalDimensions.current
}
