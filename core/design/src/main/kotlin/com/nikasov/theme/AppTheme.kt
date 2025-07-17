package com.nikasov.theme

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.nikasov.design.AppShapes
import com.nikasov.design.AppTypography
import com.nikasov.design.Dimensions
import com.nikasov.design.LocalDimensions

val ColorScheme.isLight: Boolean get() = background.luminance() > 0.5f

val Configuration.isSystemInDarkTheme
    get() = (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES

//todo: Card colors, text colors, etc. should be defined in the theme
val ColorScheme.transparent: Color @Composable get() = Color.Transparent

/** Divider */
//val ColorScheme.dividerColor: Color @Composable get() = if (isLight) Green600 else Green700

/** Buttons */
//val ColorScheme.subtitleButtonBackgroundColor: Color @Composable get() = Sand200
//val ColorScheme.subtitleButtonBorderColor: Color @Composable get() = Sand300

val ColorScheme.AppCardColors: CardColors
    @Composable get() = CardDefaults.cardColors(
        containerColor = surface,
        contentColor = onSurface,
        disabledContainerColor = surfaceContainer,
        disabledContentColor = onSurface
    )

object AppAlphaValues {
    const val DISABLED = 0.38f
}

val LocalAppColors = staticCompositionLocalOf { AppColors() }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
//    val colorScheme = DarkThemeColors.takeIf { darkTheme } ?: LightThemeColors
    CompositionLocalProvider(
        LocalDimensions provides Dimensions(),
        LocalAppColors provides AppColors(),
    ) {
        MaterialTheme(
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}

object AppTheme {
    val materialColorScheme: ColorScheme @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme
    val typography: Typography @Composable @ReadOnlyComposable get() = MaterialTheme.typography
    val shapes: Shapes @Composable @ReadOnlyComposable get() = MaterialTheme.shapes
    val dimensions: Dimensions @Composable @ReadOnlyComposable get() = LocalDimensions.current
    val appColors: AppColors @Composable @ReadOnlyComposable get() = LocalAppColors.current
}
