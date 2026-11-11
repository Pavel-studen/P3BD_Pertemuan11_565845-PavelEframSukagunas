package com.example.countercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.countercompose.ui.theme.CounterComposeTheme
import com.example.countercompose.DataDiriApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterComposeTheme {
                var currentScreen by rememberSaveable { mutableStateOf("counter") }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when(currentScreen){
                        "counter" -> CounterApp(
                            onNext = { currentScreen = "dataDiri" },
                            modifier = Modifier.padding(innerPadding)
                        )
                        "dataDiri" -> DataDiriApp(
                            onBack = { currentScreen = "counter" },
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}