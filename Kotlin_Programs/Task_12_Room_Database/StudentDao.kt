package com.example.task12db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentDao {
    @Insert
    suspend fun insertdata(student: Student)
}
