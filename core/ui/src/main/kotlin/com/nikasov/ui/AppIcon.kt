package com.nikasov.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

sealed class AppIcon(@param:DrawableRes val drawableRes: Int, @param:StringRes private val contentDescriptionRes: Int?) {

    data object Home : AppIcon(android.R.drawable.ic_media_play, android.R.string.paste_as_plain_text)
    data object Details : AppIcon(android.R.drawable.ic_media_pause, android.R.string.cancel)

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        tint: Color = Color.Unspecified,
        enabled: Boolean = true,
        @StringRes contentDescriptionResOverride: Int? = null,
        onClick: (() -> Unit)? = null
    ) {
        val icon = @Composable {
            Icon(
                modifier = if (onClick == null) modifier else Modifier,
                painter = painterResource(drawableRes),
                contentDescription = (contentDescriptionResOverride ?: contentDescriptionRes)?.let { stringResource(id = it) },
                tint = tint
            )
        }
        when (onClick != null) {
            true -> IconButton(modifier = modifier, enabled = enabled, onClick = onClick) { icon() }
            false -> icon()
        }
    }
}