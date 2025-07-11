package com.nikasov.appstructure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nikasov.appstructure.navigation.graph.RootNavHost
import com.nikasov.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            enableEdgeToEdge()
            AppTheme(
                content = {
                    RootNavHost()
                }
            )
        }
    }
}