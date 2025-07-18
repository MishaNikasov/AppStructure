package com.nikasov.appstructure.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = CenterHorizontally,
        ) {
            items(20) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = onClick,
                ) {
                    Text(
                        text = "Item $index",
                        textAlign = Center,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
//        Text(text, textAlign = Center)
//        val logger = LocalLogger.current
//        Button(onClick) {
//            Text("Click Me")
//            logger.d("Button clicked in HomeScreen")
//        }
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