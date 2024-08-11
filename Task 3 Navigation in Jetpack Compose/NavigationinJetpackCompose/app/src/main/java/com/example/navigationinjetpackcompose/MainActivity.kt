package com.example.navigationinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.navigationinjetpackcompose.ui.theme.NavigationInJetpackComposeTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material.TopAppBar
import androidx.compose.material3.BottomAppBar
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationInJetpackComposeTheme {
                val navController = rememberNavController() as NavHostController
                ScaffoldExample(navController)
            }
        }
    }
}

@Composable
fun Screen1(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { navController.navigate("screen2") }) {
            Text("Navigate to Screen 2")
        }
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { navController.navigate("screen1") }) {
            Text("Navigate to Screen 1")
        }
    }
}

@Composable
fun ScaffoldExample(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("My App") }) },
        bottomBar = {
            BottomAppBar {
                Button(onClick = { navController.navigate("screen1") }) {
                    Text("Go to Screen 1")
                }
                Button(onClick = { navController.navigate("screen2") }) {
                    Text("Go to Screen 2")
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "screen1",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("screen1") { Screen1(navController) }
            composable("screen2") { Screen2(navController) }
        }
    }
}
