package com.example.task9quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

data class Question(val text: String, val options: List<String>, val answer: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val n = rememberNavController()
            NavHost(navController = n, startDestination = "title") {
                composable("title") {
                    TitleScreen(n)
                }
                composable("game") {
                    GameScreen()
                }
            }
        }
    }
}

@Composable
fun TitleScreen(n: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome all", color = Color.Red, fontSize = 45.sp)
        Spacer(modifier = Modifier.height(45.dp))
        Button(onClick = { n.navigate("game") }) {
            Text("start game")
        }
    }
}

@Composable
fun GameScreen() {
    val question = Question(
        text = "What is official language for Android development?",
        options = listOf("Java", "Kotlin", "python", "c++"),
        answer = "Kotlin"
    )
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var showResult by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(question.text, color = Color.Red, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))

        question.options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (selectedOption == option),
                    onClick = { selectedOption = option }
                )
                Text(option, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { showResult = true },
            enabled = (selectedOption != null)
        ) {
            Text("submit")
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (showResult) {
            if (selectedOption == question.answer) {
                Text("Correct!", color = Color.Green, fontSize = 18.sp)
            } else {
                Text("Wrong! the correct answer is " + question.answer, color = Color.Red, fontSize = 18.sp)
            }
        }
    }
}
