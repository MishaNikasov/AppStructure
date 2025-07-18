package com.nikasov.appstructure.hub.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
import com.nikasov.theme.AppTheme.appColors

@Composable
fun HubScreen(
    viewModel: HubViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(appColors.bubblegum)
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .height(64.dp)
                    .background(appColors.bubblegum)
            ) {
                Text("Hub Screen")
            }
        },
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { padding ->
        HubScreen(
            state = uiState,
            onEvent = { event -> viewModel.eventHandler(event) },
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        )
    }
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

