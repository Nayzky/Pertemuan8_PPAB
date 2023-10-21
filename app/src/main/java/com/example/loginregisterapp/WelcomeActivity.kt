// WelcomeActivity.kt

package com.example.loginregisterapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "extra_username"

        fun newIntent(context: Context, username: String): Intent {
            val intent = Intent(context, WelcomeActivity::class.java)
            intent.putExtra(EXTRA_USERNAME, username)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val welcomeMessage = "Welcome, $username!"
        val textView = findViewById<TextView>(R.id.tvWelcomeMessage)
        textView.text = welcomeMessage

        val backButton = findViewById<Button>(R.id.btnBackToStart)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
