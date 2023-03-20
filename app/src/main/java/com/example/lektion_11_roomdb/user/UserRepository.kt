package com.example.lektion_11_roomdb.user

import com.example.lektion_11_roomdb.AppDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UserRepository(
    private val appDatabase: AppDatabase,       // Our Database Class
    private val coroutineScope: CoroutineScope  // Allows work with Threads
    ) {

    /* TODO - DEFINE OUR METHODS FOR QUERIES */

    fun addUser(user: User) {
        appDatabase.userDao().addUser(user)
    }

    fun getAllUsers(): List<User> {
        return appDatabase.userDao().getAllUsers()
    }

    // Allows Working with Threads
    fun performDatabaseOperation(
        dispatcher: CoroutineDispatcher,
        databaseOperation: suspend () -> Unit
    ) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }
}
