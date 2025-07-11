package com.nikasov.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import com.nikasov.theme.AppTheme.dimensions

@SuppressLint("ComposableNaming")
object VerticalSpacer {
    /** 4dp **/
    val Tiny @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingTiny))

    /** 8dp **/
    val Small @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingSmall))

    /** 12dp **/
    val Medium @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingMedium))

    /** 16dp **/
    val Normal @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingNormal))

    /** 24dp **/
    val Large @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingLarge))

    /** 32dp **/
    val Huge @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingHuge))

    /** 48dp **/
    val Enormous @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingEnormous))

    /** 64dp **/
    val Gigantic @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.height(dimensions.spacingGigantic))

    @Composable @NonRestartableComposable fun ColumnScope.Fill() { Spacer(modifier = Modifier.weight(1f, fill = true)) }
}

@SuppressLint("ComposableNaming")
object HorizontalSpacer {
    /** 4dp **/
    val Tiny @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingTiny))

    /** 8dp **/
    val Small @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingSmall))

    /** 12dp **/
    val Medium @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingMedium))

    /** 16dp **/
    val Normal @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingNormal))

    /** 24dp **/
    val Large @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingLarge))

    /** 32dp **/
    val Huge @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingHuge))

    /** 48dp **/
    val Enormous @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingEnormous))

    /** 64dp **/
    val Gigantic @Composable @NonRestartableComposable get() = Spacer(modifier = Modifier.width(dimensions.spacingGigantic))

    @Composable @NonRestartableComposable fun RowScope.Fill() { Spacer(modifier = Modifier.weight(1f, fill = true)) }
}