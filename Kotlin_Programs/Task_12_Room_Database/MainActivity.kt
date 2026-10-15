package com.example.task12db

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
INSTRUCTIONS:
1. Open gradle/libs.versions.toml:
   - Under [versions]:
       room = "2.8.5"
       ksp = "2.2.10-2.0.2"
   - Under [libraries]:
       androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }
       androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "room" }
       androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }
   - Under [plugins]:
       ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }

2. Open app/build.gradle.kts:
   - Inside plugins { ... }:
       alias(libs.plugins.ksp)
   - Inside dependencies { ... }:
       implementation(libs.androidx.room.runtime)
       implementation(libs.androidx.room.ktx)
       ksp(libs.androidx.room.compiler)
3. Click Sync Now

4. In the same folder as MainActivity.kt -> create 3 Kotlin files:
   - Student.kt
   - StudentDao.kt
   - StudentDatabase.kt
5. Match package name in line 1 of all 4 files
6. Click Run
7. View database table: Top menu -> View -> Tool Windows -> App Inspection -> Database Inspector -> select student table
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = StudentDatabase.getInstance(this)
        val studentdao = database.studentdao()
        setContent {
            insertdata(studentdao)
        }
    }
}

@Composable
fun insertdata(studentDao: StudentDao) {
    val context = LocalContext.current
    var name by remember { mutableStateOf(value = "") }
    var course by remember { mutableStateOf(value = "") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("DataBase Application")
        Spacer(modifier = Modifier.height(35.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name:") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(35.dp))
        OutlinedTextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Enter Course:") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(35.dp))
        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                studentDao.insertdata(Student(name = name, course = course))
            }
        }) {
            Text("Insert Data")
        }
    }
}
