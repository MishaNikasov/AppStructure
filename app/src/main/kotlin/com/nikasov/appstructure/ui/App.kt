package com.nikasov.appstructure.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nikasov.appstructure.navigation.RootNavHost

@Composable

fun App(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        containerColor = Color.Transparent,
    ) { padding ->
        Box(
            modifier = modifier
                .padding(padding)
                .consumeWindowInsets(padding)

        ) {
            RootNavHost()
        }
    }
}