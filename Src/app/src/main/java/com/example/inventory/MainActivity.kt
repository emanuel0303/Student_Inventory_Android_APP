package com.example.inventory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var ed1: EditText
    private lateinit var ed3: EditText
    private lateinit var ed4: EditText
    private lateinit var ed5: EditText
    private lateinit var ed6: EditText
    private lateinit var ed7: EditText
    private lateinit var ed8: EditText
    private lateinit var ed9: EditText
    private lateinit var ed10: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EditText fields and Button
        ed1 = findViewById(R.id.ed1)
        ed3 = findViewById(R.id.ed3)
        ed4 = findViewById(R.id.ed4)
        ed5 = findViewById(R.id.ed5)
        ed6 = findViewById(R.id.ed6)
        ed7 = findViewById(R.id.ed7)
        ed8 = findViewById(R.id.ed8)
        ed9 = findViewById(R.id.ed9)
        ed10 = findViewById(R.id.ed10)
        nextButton = findViewById(R.id.btn1)

        // Set click listener for the nextButton
        nextButton.setOnClickListener {
            // Retrieve data from EditText fields
            val name = ed1.text.toString()
            val dob = ed3.text.toString()
            val gender = ed4.text.toString()
            val age = ed5.text.toString()
            val address = ed6.text.toString()
            val email = ed7.text.toString()
            val mobilenum = ed8.text.toString()
            val education = ed9.text.toString()
            val informantName = ed10.text.toString()

            // Check if any field is empty
            if (name.isEmpty() || dob.isEmpty() || gender.isEmpty() || age.isEmpty() ||
                address.isEmpty() || email.isEmpty() || mobilenum.isEmpty() || education.isEmpty() ||
                informantName.isEmpty()
            ) {
                // Show a toast message indicating to fill all fields
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // All fields are filled, navigate to the next activity
                val intent = Intent(this, ConcernsActivity::class.java).apply {
                    putExtra("name", name)
                    putExtra("dob", dob)
                    putExtra("gender", gender)
                    putExtra("age", age)
                    putExtra("address", address)
                    putExtra("email", email)
                    putExtra("mobilenum", mobilenum)
                    putExtra("education", education)
                    putExtra("informantName", informantName)
                }
                startActivity(intent)
            }
        }
    }
}
