package com.nikasov.appstructure.hub.navigation

import androidx.compose.runtime.Composable
import com.nikasov.ui.AppIcon

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

    val icon: AppIcon
        @Composable get() =
            when (this) {
                is Home -> AppIcon.Home
                is Details -> AppIcon.Details
            }

}