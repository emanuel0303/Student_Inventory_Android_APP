package com.example.inventory

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class ConcernsActivity : AppCompatActivity() {

    private lateinit var nextButton: Button
    private lateinit var concern1EditText: TextInputEditText
    private lateinit var concern2EditText: TextInputEditText
    private lateinit var concern3EditText: TextInputEditText
    private lateinit var modeOfOnsetSpinner: Spinner
    private lateinit var durationSpinner: Spinner
    private lateinit var sleepSpinner: Spinner
    private lateinit var appetiteSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)

        // Initialize views
        nextButton = findViewById(R.id.next_button)
        concern1EditText = findViewById(R.id.concern_1_edit_text)
        concern2EditText = findViewById(R.id.concern_2_edit_text)
        concern3EditText = findViewById(R.id.concern_3_edit_text)
        modeOfOnsetSpinner = findViewById(R.id.mode_of_onset_spinner)
        durationSpinner = findViewById(R.id.duration_spinner)
        sleepSpinner = findViewById(R.id.sleep_spinner)
        appetiteSpinner = findViewById(R.id.appetite_spinner)

        // Set click listener for Next button
        nextButton.setOnClickListener {
            // Check if all fields are filled
            if (areAllFieldsFilled()) {
                // Proceed to next activity
                goToNextActivity()
            } else {
                // If any field is empty, show a toast message
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Add text change listeners to EditText fields to update button state
        concern1EditText.addTextChangedListener(textWatcher)
        concern2EditText.addTextChangedListener(textWatcher)
        concern3EditText.addTextChangedListener(textWatcher)
    }

    // Function to check if all fields are filled
    private fun areAllFieldsFilled(): Boolean {
        // Check if all fields are filled
        return (concern1EditText.text?.isNotEmpty() == true &&
                concern2EditText.text?.isNotEmpty() == true &&
                concern3EditText.text?.isNotEmpty() == true)
    }

    // Function to start next activity
    private fun goToNextActivity() {
        val name = intent.getStringExtra("name")
        val dob = intent.getStringExtra("dob")
        val gender = intent.getStringExtra("gender")
        val age = intent.getStringExtra("age")
        val address = intent.getStringExtra("address")
        val email = intent.getStringExtra("email")
        val mobilenum = intent.getStringExtra("mobilenum")
        val education = intent.getStringExtra("education")
        val informantName = intent.getStringExtra("informantName")

        // If all fields are filled, start the next activity
        val intent = Intent(this, ParentsActivity::class.java).apply {
            // Put the data entered on the ConcernsActivity as extras
            putExtra("name", name)
            putExtra("dob", dob)
            putExtra("gender", gender)
            putExtra("age", age)
            putExtra("address", address)
            putExtra("email", email)
            putExtra("mobilenum", mobilenum)
            putExtra("education", education)
            putExtra("informantName", informantName)
            putExtra("concern1", concern1EditText.text.toString())
            putExtra("concern2", concern2EditText.text.toString())
            putExtra("concern3", concern3EditText.text.toString())
            putExtra("modeOfOnset", modeOfOnsetSpinner.selectedItem.toString())
            putExtra("duration", durationSpinner.selectedItem.toString())
            putExtra("sleep", sleepSpinner.selectedItem.toString())
            putExtra("appetite", appetiteSpinner.selectedItem.toString())
        }
        startActivity(intent)
    }

    // TextWatcher to enable/disable Next button based on text changes
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Enable/disable Next button based on field completion
            nextButton.isEnabled = areAllFieldsFilled()
        }

        override fun afterTextChanged(s: Editable?) {}
    }
}
