package com.nikasov.appstructure.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.nikasov.appstructure.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

fun NavGraphBuilder.homeScreen(
    onSecondScreen: () -> Unit,
) {
    composable<HomeRoute> {
        HomeScreen("Home Screen") {
            onSecondScreen()
        }
    }
}


/** Test screen routes - should be separate feature module for each screen */

@Serializable
object HomeSecondScreenRoute

fun NavController.navigateToSecondScreen(navOptions: NavOptionsBuilder.() -> Unit = {}) = navigate(route = HomeSecondScreenRoute, navOptions)

fun NavGraphBuilder.homeSecondScreenScreen(onBack: () -> Unit) {
    composable<HomeSecondScreenRoute> {
        HomeScreen("Home Second Screen") { onBack() }
    }
}

@Serializable
object HomeDetailsRoute

fun NavGraphBuilder.homeDetailsScreen() {
    composable<HomeDetailsRoute> {
        HomeScreen("Home Details Screen")
    }
}
