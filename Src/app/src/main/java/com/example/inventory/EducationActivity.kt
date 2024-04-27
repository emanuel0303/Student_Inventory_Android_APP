package com.example.inventory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EducationActivity : AppCompatActivity() {

    private lateinit var editHealth: EditText
    private lateinit var editTraumas: EditText
    private lateinit var editEducation: EditText
    private lateinit var editRemarks: EditText
    private lateinit var editMenstrualHistory: EditText
    private lateinit var editHomosexuality: EditText
    private lateinit var radioGroupLoveRelationship: RadioGroup
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)

        // Find all views by their IDs
        editHealth = findViewById(R.id.edit_health)
        editTraumas = findViewById(R.id.edit_traumas)
        editEducation = findViewById(R.id.edit_education)
        editRemarks = findViewById(R.id.edit_remarks)
        editMenstrualHistory = findViewById(R.id.edit_menstrual_history)
        editHomosexuality = findViewById(R.id.edit_homosexuality)
        radioGroupLoveRelationship = findViewById(R.id.radio_group_love_relationship)
        btnNext = findViewById(R.id.btn_next)

        // Retrieve data passed from the previous activity
        val name = intent.getStringExtra("name")
        val dob = intent.getStringExtra("dob")
        val gender = intent.getStringExtra("gender")
        val age = intent.getStringExtra("age")
        val address = intent.getStringExtra("address")
        val email = intent.getStringExtra("email")
        val mobilenum = intent.getStringExtra("mobilenum")
        val education = intent.getStringExtra("education")
        val informantName = intent.getStringExtra("informantName")
        val concern1 = intent.getStringExtra("concern1")
        val concern2 = intent.getStringExtra("concern2")
        val concern3 = intent.getStringExtra("concern3")
        val modeOfOnset = intent.getStringExtra("modeOfOnset")
        val duration = intent.getStringExtra("duration")
        val sleep = intent.getStringExtra("sleep")
        val appetite = intent.getStringExtra("appetite")
        val natureOfTreatment = intent.getStringExtra("natureOfTreatment")
        val medicine = intent.getStringExtra("medicine")
        val treatmentDuration = intent.getStringExtra("duration")
        val medicalHistory = intent.getStringExtra("medicalHistory")
        val medicalHistoryDescription = intent.getStringExtra("medicalHistoryDescription")
        val response = intent.getStringExtra("response")
        val familyHistory = intent.getStringExtra("familyHistory")
        val familyType = intent.getStringExtra("familyType")
        val consanguinity = intent.getStringExtra("consanguinity")
        val parentalMarriage = intent.getStringExtra("parentalMarriage")
        val residence = intent.getStringExtra("residence")
        val familySize = intent.getStringExtra("familySize")
        val familyIncome = intent.getStringExtra("familyIncome")

        // Set onClickListener to the "Next" button
        btnNext.setOnClickListener {
            // Check if all fields are filled
            if (areAllFieldsFilled()) {
                // If all fields are filled, proceed to the next activity
                val intent = Intent(this, OccupationActivity::class.java).apply {
                    // Put all the data into the intent
                    putExtra("name", name)
                    putExtra("dob", dob)
                    putExtra("gender", gender)
                    putExtra("age", age)
                    putExtra("address", address)
                    putExtra("email", email)
                    putExtra("mobilenum", mobilenum)
                    putExtra("education", education)
                    putExtra("informantName", informantName)
                    putExtra("concern1", concern1)
                    putExtra("concern2", concern2)
                    putExtra("concern3", concern3)
                    putExtra("modeOfOnset", modeOfOnset)
                    putExtra("duration", duration)
                    putExtra("sleep", sleep)
                    putExtra("appetite", appetite)
                    putExtra("natureOfTreatment", natureOfTreatment)
                    putExtra("medicine", medicine)
                    putExtra("duration", treatmentDuration)
                    putExtra("medicalHistory", medicalHistory)
                    putExtra("medicalHistoryDescription", medicalHistoryDescription)
                    putExtra("response", response)
                    putExtra("familyHistory", familyHistory)
                    putExtra("familyType", familyType)
                    putExtra("consanguinity", consanguinity)
                    putExtra("parentalMarriage", parentalMarriage)
                    putExtra("residence", residence)
                    putExtra("familySize", familySize)
                    putExtra("familyIncome", familyIncome)
                    putExtra("health_details", editHealth.text.toString())
                    putExtra("trauma_details", editTraumas.text.toString())
                    putExtra("education_qualification", editEducation.text.toString())
                    putExtra("remarks", editRemarks.text.toString())
                    putExtra("menstrual_history", editMenstrualHistory.text.toString())
                    putExtra("homosexuality_response", editHomosexuality.text.toString())
                    putExtra("love_relationship_response", getSelectedRadioButtonText())
                }
                startActivity(intent)
            } else {
                // If any field is empty, show a toast message
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to check if all fields are filled
    private fun areAllFieldsFilled(): Boolean {
        // Check all required fields here, return false if any field is empty
        return (editHealth.text.isNotEmpty() &&
                editTraumas.text.isNotEmpty() &&
                editEducation.text.isNotEmpty() &&
                editRemarks.text.isNotEmpty() &&
                editMenstrualHistory.text.isNotEmpty() &&
                editHomosexuality.text.isNotEmpty() &&
                isResponseSelected())
    }

    // Function to check if a response in the radio group is selected
    private fun isResponseSelected(): Boolean {
        return radioGroupLoveRelationship.checkedRadioButtonId != -1
    }

    // Function to get the selected radio button text
    private fun getSelectedRadioButtonText(): String {
        val selectedRadioButtonId = radioGroupLoveRelationship.checkedRadioButtonId
        return findViewById<RadioButton>(selectedRadioButtonId).text.toString()
    }
}
