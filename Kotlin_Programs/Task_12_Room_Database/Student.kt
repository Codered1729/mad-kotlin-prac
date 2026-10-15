package com.example.task12db

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
INSTRUCTIONS:
Room Entity for Student table. Match package name in line 1 to your project.
*/

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val course: String = ""
)
