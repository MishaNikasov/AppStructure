package com.nikasov.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.nikasov.design.AppPreview
import com.nikasov.design.body_1
import com.nikasov.theme.AppTheme
import com.nikasov.theme.AppTheme.appColors
import com.nikasov.theme.AppTheme.dimensions
import com.nikasov.theme.AppTheme.typography
import com.nikasov.ui.IconPosition.End
import com.nikasov.ui.IconPosition.Start

enum class IconPosition {
    Start,
    End;
}

data class ButtonIcon(
    val appIcon: AppIcon,
    val position: IconPosition
)

enum class ButtonSize {
    Small,
    Medium,
    Large;

    val height: Dp
        @Composable get() = when (this) {
            Small -> dimensions.buttonHeightSmall
            Medium -> dimensions.buttonHeightMedium
            Large -> dimensions.buttonHeightLarge
        }
}

sealed interface AppButton {
    data object Primary : AppButton
    data object Secondary : AppButton
    data object Subtitle : AppButton

    private val shape: Shape
        @Composable get() = RoundedCornerShape(dimensions.buttonShapeCornerRadius)

    private val spacing: Dp
        @Composable get() = dimensions.buttonSpacing

    private val backgroundColor: Color
        @Composable get() = when (this) {
            Primary -> appColors.green500
            Secondary -> appColors.transparent
            Subtitle -> appColors.sand300
        }

    private val textColor: Color
        @Composable get() = when (this) {
            Primary -> appColors.white
            Secondary -> appColors.black
            Subtitle -> appColors.black
        }

    private val textStyle: TextStyle
        @Composable get() = typography.body_1

    private val borderStroke: BorderStroke?
        @Composable get() = when (this) {
            Subtitle -> BorderStroke(
                width = dimensions.borderThickness,
                color = appColors.sand200
            )

            else -> null
        }

    @Composable
    private fun contentPadding(size: ButtonSize): PaddingValues {
        return when (size) {
            ButtonSize.Small -> PaddingValues(horizontal = dimensions.spacingNormal)
            else -> PaddingValues(horizontal = dimensions.spacingLarge)
        }
    }

    @Composable
    operator fun invoke(
        text: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        allCaps: Boolean = false,
        isLoading: Boolean = false,
        icon: ButtonIcon? = null,
        size: ButtonSize = ButtonSize.Medium,
        onClick: () -> Unit
    ) {
        Button(
            modifier = modifier.height(size.height),
            enabled = enabled,
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = textColor
            ),
            shape = shape,
            contentPadding = contentPadding(size),
            border = borderStroke,
        ) {
            when {
                isLoading -> CircularProgressIndicator()
                icon == null -> ButtonText(text = text, allCaps = allCaps)
                else -> {
                    when (icon.position) {
                        Start -> Row(
                            horizontalArrangement = spacedBy(spacing),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            icon.appIcon(
                                modifier = Modifier,
                                tint = textColor,
                            )
                            ButtonText(text = text, allCaps = allCaps)
                        }

                        End -> Row(
                            horizontalArrangement = spacedBy(spacing),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ButtonText(text = text, allCaps = allCaps)
                            icon.appIcon(
                                modifier = Modifier,
                                tint = textColor,
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ButtonText(text: String, allCaps: Boolean) = Text(
        text = if (allCaps) text.uppercase() else text,
        style = textStyle,
    )
}

@AppPreview
@Composable
private fun PrimaryButtonPreview() {
    AppTheme {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(appColors.white)
                .padding(dimensions.spacingNormal),
            horizontalArrangement = spacedBy(dimensions.spacingNormal),
            verticalArrangement = spacedBy(dimensions.spacingNormal, Alignment.CenterVertically)
        ) {
            AppButton.Primary(
                text = "Primary",
                modifier = Modifier,
                enabled = true,
                onClick = {},
                size = ButtonSize.Small,
            )
            AppButton.Primary(
                text = "Primary",
                modifier = Modifier,
                enabled = true,
                size = ButtonSize.Medium,
                onClick = {},
            )
            AppButton.Primary(
                text = "Primary",
                modifier = Modifier,
                enabled = true,
                size = ButtonSize.Large,
                icon = ButtonIcon(
                    appIcon = AppIcon.Home,
                    position = Start
                ),
                onClick = {},
            )
        }
    }
}

@AppPreview
@Composable
private fun SecondaryButtonPreview() {
    AppTheme {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(appColors.white)
                .padding(dimensions.spacingNormal),
            horizontalArrangement = spacedBy(dimensions.spacingNormal),
            verticalArrangement = spacedBy(dimensions.spacingNormal, Alignment.CenterVertically)
        ) {
            AppButton.Secondary(
                text = "Secondary",
                modifier = Modifier,
                enabled = true,
                onClick = {},
            )
            AppButton.Secondary(
                text = "Secondary",
                modifier = Modifier,
                enabled = true,
                icon = ButtonIcon(
                    appIcon = AppIcon.Home,
                    position = Start
                ),
                onClick = {},
            )
        }
    }
}

@AppPreview
@Composable
private fun SubtitleButtonPreview() {
    AppTheme {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(appColors.sand600)
                .padding(dimensions.spacingNormal),
            horizontalArrangement = spacedBy(dimensions.spacingNormal),
            verticalArrangement = spacedBy(dimensions.spacingNormal, Alignment.CenterVertically)
        ) {
            AppButton.Subtitle(
                text = "Subtitle",
                modifier = Modifier,
                enabled = true,
                size = ButtonSize.Small,
                onClick = {},
            )
            AppButton.Subtitle(
                text = "Subtitle",
                modifier = Modifier,
                enabled = true,
                size = ButtonSize.Medium,
                onClick = {},
            )
            AppButton.Subtitle(
                text = "Subtitle",
                modifier = Modifier,
                enabled = true,
                size = ButtonSize.Large,
                icon = ButtonIcon(
                    appIcon = AppIcon.Home,
                    position = Start
                ),
                onClick = {},
            )
        }
    }
}