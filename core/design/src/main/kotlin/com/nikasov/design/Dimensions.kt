package com.nikasov.design

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimensions(
    /** Spacing **/
    val spacingTiny: Dp = 4.dp,
    val spacingSmall: Dp = 8.dp,
    val spacingMedium: Dp = 12.dp,
    val spacingNormal: Dp = 16.dp,
    val spacingLarge: Dp = 24.dp,
    val spacingHuge: Dp = 32.dp,
    val spacingEnormous: Dp = 48.dp,
    val spacingGigantic: Dp = 64.dp,

    /** Button **/
    val buttonHeightSmall: Dp = 40.dp,
    val buttonHeightMedium: Dp = 48.dp,
    val buttonHeightLarge: Dp = 52.dp,
    val buttonShapeCornerRadius: Dp = 60.dp,
    val buttonSpacing: Dp = 8.dp,

    /** Icon **/
    val iconSizeExtraTiny: Dp = 12.dp,
    val iconSizeTiny: Dp = 16.dp,
    val iconSizeSmall: Dp = 20.dp,
    val iconSizeNormal: Dp = 24.dp,
    val iconSizeLarge: Dp = 32.dp,
    val iconSizeHuge: Dp = 64.dp,
    val iconSizeToolbar: Dp = 44.dp,

    /** Divider **/
    val dividerThickness: Dp = 1.dp,

    /** Border **/
    val borderThickness: Dp = 2.dp,

    /** Input field **/
    val inputFieldHeight: Dp = 36.dp,

    /** Bottom navigation **/
    val bottomNavigationHeight: Dp = 56.dp,
    val bottomNavigationSpacing: Dp = 34.dp,
    val bottomNavigationItemSize: Dp = 48.dp,
    val bottomNavigationRadius: Dp = 34.dp,
    val bottomNavigationHorizontalPadding: Dp = 12.dp,
    val bottomNavigationVerticalPadding: Dp = 4.dp,
    val bottomNavigationItemSpacing: Dp = 7.dp,
)

val LocalDimensions = staticCompositionLocalOf { Dimensions() }