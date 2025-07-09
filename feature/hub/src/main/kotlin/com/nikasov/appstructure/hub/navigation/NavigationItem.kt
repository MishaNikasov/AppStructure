package com.nikasov.appstructure.hub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

val bottomNavigationItems = listOf(
    NavigationItem.Home,
    NavigationItem.Details,
)

sealed interface NavigationItem {

    data object Home : NavigationItem
    data object Details : NavigationItem

    val graph: Any
        get() = when (this) {
            is Home -> HomeGraph
            is Details -> HomeDetailsGraph
        }

    val icon: Painter
        @Composable get() =
            when (this) {
                is Home -> painterResource(android.R.drawable.ic_menu_add)
                is Details -> painterResource(android.R.drawable.ic_dialog_dialer)
            }

}