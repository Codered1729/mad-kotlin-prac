package com.example.cupcake

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var flavor by remember { mutableStateOf("Chocolate") }
            var qty by remember { mutableStateOf("1") }
            var date by remember { mutableStateOf("Today") }
            var order by remember { mutableStateOf("") }

            Column(Modifier.padding(16.dp)) {
                Text("Cupcake Order")

                Text("Flavor")
                Row {
                    listOf("Chocolate", "Vanilla", "Strawberry").forEach {
                        Button(onClick = { flavor = it }) {
                            Text(it)
                        }
                    }
                }

                Text("Quantity")
                Row {
                    listOf("1", "2", "3").forEach {
                        Button(onClick = { qty = it }) {
                            Text(it)
                        }
                    }
                }

                Text("Pickup Date")
                Button(onClick = {
                    date = if (date == "Today") "Tomorrow" else "Today"
                }) {
                    Text(date)
                }

                Button(onClick = {
                    order = "$qty $flavor cupcake(s), Pickup: $date"
                }) {
                    Text("Place Order")
                }

                if (order.isNotEmpty()) {
                    Text(order)

                    Button(onClick = {
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, order)
                        }
                        startActivity(Intent.createChooser(intent, "Send Order"))
                    }) {
                        Text("Send Order")
                    }

                    Button(onClick = { order = "" }) {
                        Text("Cancel Order")
                    }
                }
            }
        }
    }
}
