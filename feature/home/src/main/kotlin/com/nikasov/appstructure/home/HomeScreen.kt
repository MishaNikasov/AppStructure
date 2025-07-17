package com.nikasov.appstructure.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import com.nikasov.common_android.logger.LocalLogger

@Composable
fun HomeScreen(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(text, textAlign = Center)
        val logger = LocalLogger.current
        Button(onClick) {
            Text("Click Me")
            logger.d("Button clicked in HomeScreen")
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        "test",
        onClick = { },
    )
}