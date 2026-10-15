package com.example.counter_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

/*
INSTRUCTIONS:
1. In app/build.gradle.kts -> inside dependencies { ... }, add:
   implementation("androidx.compose.runtime:runtime-livedata:1.7.6")
   implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
2. Click Sync Now
3. Project folder -> right click -> New -> Kotlin Class/File -> name: CounterViewModel
4. Match package name in line 1 of both files
5. Click Run
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screens()
        }
    }
}

@Composable
fun Screens(counterViewModel: CounterViewModel = viewModel()) {
    val counter by counterViewModel.c.observeAsState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(50.dp))
        Text("Count: $counter", fontSize = 35.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { counterViewModel.increment() }) {
            Text("Increment")
        }
    }
}
