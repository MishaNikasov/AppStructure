package com.nikasov.appstructure.hub.ui.bottomNavigation

import androidx.compose.runtime.Composable
import com.nikasov.appstructure.hub.navigation.HomeDetailsGraph
import com.nikasov.appstructure.hub.navigation.HomeGraph
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