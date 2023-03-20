package com.example.lektion_11_roomdb.user

import androidx.room.Entity
import androidx.room.PrimaryKey

/* INFO
* @Entity("TableName") <-- Specifies your own table name
* @PrimaryKey(autogenerate = true) <-- Automatically increment ID
* @ColumInfo("") <-- Specify your own column name
* */

@Entity("Users")
data class User(
    val username: String,
    val password: String,
    val role: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

}