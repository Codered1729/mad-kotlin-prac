package com.example.task3_f

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/*
INSTRUCTIONS:
1. Create new project -> Empty Activity (Jetpack Compose)
2. Match package name in line 1 to your project
3. Click Run
4. View output: Open Logcat window at bottom -> filter: Lifecycle
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showToast("onCreate called")
        Log.d("Lifecycle", "onCreate called")
        setContent {
            display()
        }
    }

    override fun onStart() {
        super.onStart()
        showToast("onStart called")
        Log.d("Lifecycle", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        showToast("onResume called")
        Log.d("Lifecycle", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        showToast("onPause called")
        Log.d("Lifecycle", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        showToast("onStop called")
        Log.d("Lifecycle", "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        showToast("onRestart called")
        Log.d("Lifecycle", "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("onDestroy called")
        Log.d("Lifecycle", "onDestroy called")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun display() {
    Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center) {
        Text("Hello World", modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center), color = Color.Red)
    }
}
