package com.example.guessthewrd_task11

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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessTheWordApp()
        }
    }
}

@Composable
fun GuessTheWordApp() {
    val words = listOf("Desk", "Chair", "Guitar", "Phone", "Book", "Computer")
    var currentWord by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var gameOver by remember { mutableStateOf(false) }

    if (gameOver) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Game Over!", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Final Score: $score", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {
                currentWord = 0
                score = 0
                gameOver = false
            }) {
                Text("Play Again")
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Guess The Word", fontSize = 30.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Player 1: Act this word", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = words[currentWord], fontSize = 40.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Score: $score", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {
                score++
                if (currentWord < words.size - 1) {
                    currentWord++
                } else {
                    gameOver = true
                }
            }) {
                Text("Got It!")
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(onClick = {
                if (currentWord < words.size - 1) {
                    currentWord++
                } else {
                    gameOver = true
                }
            }) {
                Text("Skip")
            }
        }
    }
}
