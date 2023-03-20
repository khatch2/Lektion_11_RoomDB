package com.example.lektion_11_roomdb.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// Our Queries

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM Users")
    fun getAllUsers(): List<User>

}