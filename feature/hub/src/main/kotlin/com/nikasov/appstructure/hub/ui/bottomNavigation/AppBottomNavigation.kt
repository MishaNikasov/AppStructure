package com.nikasov.appstructure.hub.ui.bottomNavigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nikasov.appstructure.hub.ui.bottomNavigationHeight
import com.nikasov.appstructure.hub.ui.bottomNavigationHorizontalPadding
import com.nikasov.appstructure.hub.ui.bottomNavigationItemSize
import com.nikasov.appstructure.hub.ui.bottomNavigationItemSpacing
import com.nikasov.appstructure.hub.ui.bottomNavigationRadius
import com.nikasov.appstructure.hub.ui.bottomNavigationSpacing
import com.nikasov.appstructure.hub.ui.bottomNavigationVerticalPadding
import com.nikasov.theme.AppTheme.appColors
import com.nikasov.theme.AppTheme.dimensions

@Composable
fun AppBottomNavigation(
    navController: NavHostController,
    bottomNavigationItems: List<NavigationItem>,
    onItemSelected: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    val entry by navController.currentBackStackEntryAsState()
    val currentDestination = entry?.destination
    Row(
        horizontalArrangement = spacedBy(dimensions.bottomNavigationItemSpacing),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = dimensions.bottomNavigationSpacing)
            .height(dimensions.bottomNavigationHeight)
            .background(color = appColors.primary800, shape = RoundedCornerShape(dimensions.bottomNavigationRadius))
            .padding(
                horizontal = dimensions.bottomNavigationHorizontalPadding,
                vertical = dimensions.bottomNavigationVerticalPadding,
            ),
    ) {
        bottomNavigationItems.forEach { item ->
            val isSelected = currentDestination?.hierarchy?.any { it.hasRoute(item.graph::class) } == true
            val iconTint by animateColorAsState(
                animationSpec = spring(stiffness = StiffnessVeryLow),
                targetValue = if (isSelected) appColors.white else appColors.primary400,
                label = "BottomNavigationIconTint",
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(dimensions.bottomNavigationItemSize)
                    .clip(RoundedCornerShape(dimensions.bottomNavigationRadius))
                    .clickable {
                        onItemSelected(item)
                    }
            ) {
                item.icon(
                    modifier = Modifier.size(dimensions.iconSizeNormal),
                    tint = iconTint,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewAppBottomNavigation() {
    AppBottomNavigation(
        navController = rememberNavController(),
        bottomNavigationItems = bottomNavigationItems,
        onItemSelected = { }
    )
}