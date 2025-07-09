package com.nikasov.appstructure.hub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.nikasov.appstructure.home.navigation.navigateToSecondScreen

@Composable
fun HubNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeGraph
    ) {
        homeGraph(
            onSecondScreen = navController::navigateToSecondScreen,
            onBack = navController::navigateUp
        )
        homeDetailsGraph()
    }
}