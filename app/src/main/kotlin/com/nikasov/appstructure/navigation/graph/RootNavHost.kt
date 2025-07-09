package com.nikasov.appstructure.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nikasov.appstructure.hub.navigation.HubRoute
import com.nikasov.appstructure.hub.navigation.hubScreen

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HubRoute
    ) {
        hubScreen()
    }
}