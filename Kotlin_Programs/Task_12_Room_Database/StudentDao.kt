package com.example.task12db

import androidx.room.Dao
import androidx.room.Insert

/*
INSTRUCTIONS:
Room DAO for Student entity. Match package name in line 1 to your project.
*/

@Dao
interface StudentDao {
    @Insert
    suspend fun insertdata(student: Student)
}
