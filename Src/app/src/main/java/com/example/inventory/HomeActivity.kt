package com.example.inventory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val registrationButton: Button = findViewById(R.id.registrationButton)


        registrationButton.setOnClickListener {
            // Navigate to com.example.inventory.MainActivity for registration
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}
