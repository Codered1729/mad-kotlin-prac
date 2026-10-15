package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
INSTRUCTIONS:
1. In app/src/main/res/drawable/ -> add 3 images:
   img1.png, img2.png, img3.png
2. Match package name in line 1
3. Click Run
*/

data class Affirmation(val text: String, val image: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationApp()
        }
    }
}

@Composable
fun AffirmationApp() {
    val a = listOf(
        Affirmation("sweet", R.drawable.img1),
        Affirmation("weight", R.drawable.img2),
        Affirmation("sour", R.drawable.img3)
    )

    LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        items(a) { obj ->
            Card(modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
                    Image(
                        painter = painterResource(obj.image),
                        contentDescription = "task 6:affirmation app",
                        modifier = Modifier.height(200.dp)
                    )
                    Spacer(modifier = Modifier.height(45.dp))
                    Text(obj.text, fontSize = 56.sp)
                }
            }
        }
    }
}
