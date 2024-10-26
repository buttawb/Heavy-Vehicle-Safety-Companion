package com.example.hggc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginFragment : AppCompatActivity() {

    // Define a list of valid username-password pairs
    private val validCredentials = listOf(
        "HGGC" to "D.usman",
        "awb" to "testawb"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if user is already logged in
        val sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            navigateToMainActivity()
            return
        }

        setContentView(R.layout.fragment_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            // Check if entered credentials are in the list of valid credentials
            if (validCredentials.contains(enteredUsername to enteredPassword)) {
                // Save login status
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
                navigateToMainActivity()
            } else {
                Toast.makeText(this, "Incorrect credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Close LoginActivity
    }
}
