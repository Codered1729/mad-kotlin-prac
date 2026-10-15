package com.example.cse_f

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// SETUP: Place 6 images named dice1, dice2, dice3, dice4, dice5, dice6 into app/src/main/res/drawable/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            diceroller()
        }
    }
}

@Composable
fun diceroller() {
    var dicevalue by remember { mutableStateOf(1) }
    val context: Context = LocalContext.current

    Column(
        modifier = Modifier.padding(34.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = getDiceImage(dicevalue)),
            contentDescription = "Diceroller App",
            modifier = Modifier.size(250.dp)
        )

        Spacer(modifier = Modifier.height(120.dp))

        Button(onClick = {
            dicevalue = (1..6).random()
            Toast.makeText(context, "dice value rolled is $dicevalue", Toast.LENGTH_SHORT).show()
        }) {
            Text("rolldice")
        }
    }
}

fun getDiceImage(dicevalue: Int): Int {
    return when (dicevalue) {
        1 -> R.drawable.dice1
        2 -> R.drawable.dice2
        3 -> R.drawable.dice3
        4 -> R.drawable.dice4
        5 -> R.drawable.dice5
        else -> R.drawable.dice6
    }
}
