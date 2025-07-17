package com.nikasov.appstructure.hub

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nikasov.appstructure.hub.components.HubEvent
import com.nikasov.appstructure.hub.components.HubState
import com.nikasov.appstructure.hub.navigation.HomeDetailsGraph
import com.nikasov.appstructure.hub.navigation.HomeGraph
import com.nikasov.appstructure.hub.navigation.HubNavHost
import com.nikasov.appstructure.hub.navigation.bottomNavigationItems
import com.nikasov.appstructure.hub.navigation.navigateHomeDetailsGraph
import com.nikasov.appstructure.hub.navigation.navigateToHomeGraph
import com.nikasov.theme.AppTheme.appColors
import com.nikasov.theme.AppTheme.dimensions

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
    val entry by navController.currentBackStackEntryAsState()
    val currentDestination = entry?.destination

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
    ) {
        HubNavHost(
            navController = navController,
            modifier = modifier.weight(1f),
        )
        HorizontalFloatingToolbar(
            expanded = true,
            modifier = Modifier
                .padding(all = 16.dp)
                .height(52.dp)
                .fillMaxWidth(),
        ) {
            bottomNavigationItems.forEach { item ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .let { boxModifier ->
                            if (currentDestination?.hierarchy?.any { it.hasRoute(item.graph::class) } == true) {
                                boxModifier.background(appColors.sand600)
                            } else {
                                boxModifier
                            }
                        }
                        .clickable {
                            when (item.graph) {
                                HomeGraph -> navController.navigateToHomeGraph()
                                HomeDetailsGraph -> navController.navigateHomeDetailsGraph()
                                else -> throw IllegalArgumentException("Unknown graph: ${item.graph}")
                            }
                        }
                ) {
                    item.icon(
                        modifier = Modifier.size(dimensions.iconSizeNormal),
                        tint = appColors.primary500,
                    )
                }
            }
        }
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

