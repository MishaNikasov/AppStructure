package com.nikasov.appstructure.hub.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.nikasov.appstructure.hub.HubViewModel
import com.nikasov.appstructure.hub.components.HubEvent
import com.nikasov.appstructure.hub.components.HubState
import com.nikasov.appstructure.hub.navigation.HomeDetailsGraph
import com.nikasov.appstructure.hub.navigation.HomeGraph
import com.nikasov.appstructure.hub.navigation.HubNavHost
import com.nikasov.appstructure.hub.navigation.navigateHomeDetailsGraph
import com.nikasov.appstructure.hub.navigation.navigateToHomeGraph
import com.nikasov.appstructure.hub.ui.bottomNavigation.AppBottomNavigation
import com.nikasov.appstructure.hub.ui.bottomNavigation.bottomNavigationItems

@Composable
fun HubScreen(
    viewModel: HubViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    HubScreen(
        state = uiState,
        onEvent = { event -> viewModel.eventHandler(event) },
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@SuppressLint("RestrictedApi")
@Composable
private fun HubScreen(
    state: HubState,
    onEvent: (HubEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        HubNavHost(
            navController = navController,
            modifier = Modifier.fillMaxSize(),
        )
        AppBottomNavigation(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController,
            bottomNavigationItems = bottomNavigationItems,
            onItemSelected = { item ->
                when (item.graph) {
                    HomeGraph -> navController.navigateToHomeGraph()
                    HomeDetailsGraph -> navController.navigateHomeDetailsGraph()
                    else -> throw IllegalArgumentException("Unknown graph: ${item.graph}")
                }
            },
        )
    }
}

@Composable
@Preview(name = "Hub")
private fun HubScreenPreview() {
    HubScreen(
        state = HubState(),
        onEvent = {}
    )
}

