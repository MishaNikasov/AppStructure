package com.nikasov.appstructure.hub.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nikasov.appstructure.home.navigation.HomeDetailsRoute
import com.nikasov.appstructure.home.navigation.HomeRoute
import com.nikasov.appstructure.home.navigation.homeDetailsScreen
import com.nikasov.appstructure.home.navigation.homeScreen
import com.nikasov.appstructure.home.navigation.homeSecondScreenScreen
import com.nikasov.appstructure.hub.ui.HubScreen
import kotlinx.serialization.Serializable

@Serializable
object HubRoute

fun NavController.navigateToHub(navOptions: NavOptionsBuilder.() -> Unit = {}) = navigate(route = HubRoute, navOptions)

fun NavGraphBuilder.hubScreen() {
    composable<HubRoute> {
        HubScreen(viewModel = hiltViewModel())
    }
}

@Serializable
object HomeGraph

fun NavController.navigateToHomeGraph(navOptions: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }) = navigate(route = HomeGraph, navOptions)

fun NavGraphBuilder.homeGraph(
    onSecondScreen: () -> Unit,
    onBack: () -> Unit,
) {
    navigation<HomeGraph>(startDestination = HomeRoute) {
        homeScreen(
            onSecondScreen = onSecondScreen,
        )
        homeSecondScreenScreen(
            onBack = onBack,
        )
    }
}

@Serializable
object HomeDetailsGraph

fun NavController.navigateHomeDetailsGraph(navOptions: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }) = navigate(route = HomeDetailsGraph, navOptions)

fun NavGraphBuilder.homeDetailsGraph() {
    navigation<HomeDetailsGraph>(startDestination = HomeDetailsRoute) {
        homeDetailsScreen()
    }
}

//@Serializable data class TopicRoute(val id: String)
//
//fun NavController.navigateToTopic(topicId: String, navOptions: NavOptionsBuilder.() -> Unit = {}) {
//    navigate(route = TopicRoute(topicId)) {
//        navOptions()
//    }
//}
//
//fun NavGraphBuilder.topicScreen(
//    showBackButton: Boolean,
//    onBackClick: () -> Unit,
//    onTopicClick: (String) -> Unit,
//) {
//    composable<TopicRoute> { entry ->
//        val id = entry.toRoute<TopicRoute>().id
//        TopicScreen(
//            showBackButton = showBackButton,
//            onBackClick = onBackClick,
//            onTopicClick = onTopicClick,
//            viewModel = hiltViewModel<TopicViewModel, TopicViewModel.Factory>(
//                key = id,
//            ) { factory ->
//                factory.create(id)
//            },
//        )
//    }
//}
