package com.example.dictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/*
INSTRUCTIONS:
1. In app/build.gradle.kts -> inside dependencies { ... }, add:
   implementation("androidx.navigation:navigation-compose:2.8.5")
2. Click Sync Now
3. Match package name in line 1
4. Click Run
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    home(navController)
                }
                composable("dictionary") {
                    dictionary(navController)
                }
                composable("word") {
                    word(navController)
                }
            }
        }
    }
}

@Composable
fun home(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("dictionary") }) {
            Text("go to dictionary", fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.height(35.dp))
        Button(onClick = { navController.navigate("word") }) {
            Text("go to word", fontSize = 25.sp)
        }
    }
}

@Composable
fun dictionary(navController: NavController) {
    var query by remember { mutableStateOf("") }
    var meaning by remember { mutableStateOf("") }
    val d = mapOf("kotlin" to "prog-language", "java" to "high level language")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("enter a word") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            meaning = d[query.trim().lowercase()] ?: "word not found"
        }) {
            Text("find meaning")
        }
        Spacer(modifier = Modifier.height(35.dp))
        Text(meaning, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(35.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("go back to home")
        }
    }
}

@Composable
fun word(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("word list is :")
        Spacer(modifier = Modifier.height(15.dp))
        Text("apple\nboy\ncse\ncvr")
        Spacer(modifier = Modifier.height(35.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("go back to home")
        }
    }
}
