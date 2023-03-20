package com.example.lektion_11_roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.lektion_11_roomdb.databinding.ActivityMainBinding
import com.example.lektion_11_roomdb.user.User
import com.example.lektion_11_roomdb.user.UserRepository
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = AppDatabase.getInstance(applicationContext)
        val userRepository = UserRepository(db, lifecycleScope)

        // Id's
        val tvUsers = binding.tvUsers
        val btnFetchUsers = binding.btnFetchUsers
        val btnInsertUser = binding.btnInsertUser


        // INSERT
        btnInsertUser.setOnClickListener {
            userRepository.performDatabaseOperation(Dispatchers.IO) {
                userRepository.addUser(
                    User("Benny", "123", "ADMIN")
                )
            }
        }

        // FETCH
        btnFetchUsers.setOnClickListener {

                userRepository.performDatabaseOperation(Dispatchers.IO) {
                    val usersList = userRepository.getAllUsers()

                    println(usersList)

                    userRepository.performDatabaseOperation(Dispatchers.Main) {
                        tvUsers.text = usersList.toString()
                    }
                }
        }
    }
}