package com.example.inventory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class ParentsActivity : AppCompatActivity() {

    private lateinit var consentButton: Button
    private lateinit var natureOfTreatmentTextBox: EditText
    private lateinit var medicineTextBox: EditText
    private lateinit var durationTextBox: EditText
    private lateinit var responseRadioGroup: RadioGroup
    private lateinit var ceasureCheckBox: CheckBox
    private lateinit var bloodPressureCheckBox: CheckBox
    private lateinit var diabeticsCheckBox: CheckBox
    private lateinit var hormonalIssuesCheckBox: CheckBox
    private lateinit var physicalInjuryCheckBox: CheckBox
    private lateinit var medicalHistoryDescriptiveBox: EditText
    private lateinit var familyHistoryTextBox: EditText
    private lateinit var familyTypeSpinner: Spinner
    private lateinit var consanguinitySpinner: Spinner
    private lateinit var parentalMarriageSpinner: Spinner
    private lateinit var residenceSpinner: Spinner
    private lateinit var familySizeEditText: EditText
    private lateinit var averageIncomeRadioButton: RadioButton
    private lateinit var belowAverageIncomeRadioButton: RadioButton
    private lateinit var aboveAverageIncomeRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parents)

        // Initialize views
        consentButton = findViewById(R.id.centerButton)
        natureOfTreatmentTextBox = findViewById(R.id.nature_of_treatment_text_box)
        medicineTextBox = findViewById(R.id.medicine_text_box)
        durationTextBox = findViewById(R.id.duration_text_box)
        responseRadioGroup = findViewById(R.id.response_radio_group)
        ceasureCheckBox = findViewById(R.id.ceasure_checkbox)
        bloodPressureCheckBox = findViewById(R.id.blood_pressure_checkbox)
        diabeticsCheckBox = findViewById(R.id.diabetics_checkbox)
        hormonalIssuesCheckBox = findViewById(R.id.hormonal_issues_checkbox)
        physicalInjuryCheckBox = findViewById(R.id.physical_injury_checkbox)
        medicalHistoryDescriptiveBox = findViewById(R.id.medical_history_descriptive_box)
        familyHistoryTextBox = findViewById(R.id.family_history_text_box)
        familyTypeSpinner = findViewById(R.id.family_type_spinner)
        consanguinitySpinner = findViewById(R.id.consanguinity_spinner)
        parentalMarriageSpinner = findViewById(R.id.parental_marriage_spinner)
        residenceSpinner = findViewById(R.id.residence_spinner)
        familySizeEditText = findViewById(R.id.family_size_edit_text)
        averageIncomeRadioButton = findViewById(R.id.average_income_radio_button)
        belowAverageIncomeRadioButton = findViewById(R.id.below_average_income_radio_button)
        aboveAverageIncomeRadioButton = findViewById(R.id.above_average_income_radio_button)

        // Receive data from the previous activity (ConcernsActivity)
        val name = intent.getStringExtra("name")
        val dob = intent.getStringExtra("dob")
        val gender = intent.getStringExtra("gender")
        val age = intent.getStringExtra("age")
        val address = intent.getStringExtra("address")
        val email = intent.getStringExtra("email")
        val mobilenum = intent.getStringExtra("mobilenum")
        val education = intent.getStringExtra("education")
        val informantName = intent.getStringExtra("informantName")

        // Get data passed from ConcernsActivity
        val concern1 = intent.getStringExtra("concern1")
        val concern2 = intent.getStringExtra("concern2")
        val concern3 = intent.getStringExtra("concern3")
        val modeOfOnset = intent.getStringExtra("modeOfOnset")
        val duration = intent.getStringExtra("duration")
        val sleep = intent.getStringExtra("sleep")
        val appetite = intent.getStringExtra("appetite")

        // Set click listener for consentButton
        consentButton.setOnClickListener {
            // Check if all fields are filled
            if (areAllDetailsFilled()) {
                // If all fields are filled, start the next activity
                val intent = Intent(this, EducationActivity::class.java).apply {
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

                    putExtra("natureOfTreatment", natureOfTreatmentTextBox.text.toString())
                    putExtra("medicine", medicineTextBox.text.toString())
                    putExtra("duration", durationTextBox.text.toString())
                    putExtra("medicalHistory", getMedicalHistory())
                    putExtra("medicalHistoryDescription", medicalHistoryDescriptiveBox.text.toString())
                    putExtra("familyHistory", familyHistoryTextBox.text.toString())
                    putExtra("familyType", familyTypeSpinner.selectedItem.toString())
                    putExtra("consanguinity", consanguinitySpinner.selectedItem.toString())
                    putExtra("parentalMarriage", parentalMarriageSpinner.selectedItem.toString())
                    putExtra("residence", residenceSpinner.selectedItem.toString())
                    putExtra("familySize", familySizeEditText.text.toString())
                    putExtra("familyIncome", getFamilyIncome())
                }
                startActivity(intent)
            } else {
                // If any field is empty, show a toast message
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun areAllDetailsFilled(): Boolean {
        // Check all required fields here, return false if any field is empty
        return (natureOfTreatmentTextBox.text.isNotEmpty() &&
                medicineTextBox.text.isNotEmpty() &&
                durationTextBox.text.isNotEmpty() &&
                familySizeEditText.text.isNotEmpty() &&
                isResponseSelected() &&
                isAtLeastOneMedicalHistorySelected() && // This condition might be causing the issue
                isValidFamilySize())
    }


    private fun isResponseSelected(): Boolean {
        // Check if any response is selected
        return responseRadioGroup.checkedRadioButtonId != -1
    }

    private fun isAtLeastOneMedicalHistorySelected(): Boolean {
        // Check if at least one medical history checkbox is selected
        return (ceasureCheckBox.isChecked || bloodPressureCheckBox.isChecked || diabeticsCheckBox.isChecked ||
                hormonalIssuesCheckBox.isChecked || physicalInjuryCheckBox.isChecked)
    }



    private fun isValidFamilySize(): Boolean {
        // Check if family size is a valid number
        val familySizeString = familySizeEditText.text.toString()
        return try {
            val familySize = familySizeString.toInt()
            familySize > 0 // Family size should be greater than 0
        } catch (e: NumberFormatException) {
            false // If family size is not a valid number
        }
    }

    private fun getMedicalHistory(): String {
        // Construct a string representing selected medical history
        val medicalHistory = StringBuilder()
        if (ceasureCheckBox.isChecked) {
            medicalHistory.append("Ceasure, ")
        }
        if (bloodPressureCheckBox.isChecked) {
            medicalHistory.append("Blood Pressure, ")
        }
        if (diabeticsCheckBox.isChecked) {
            medicalHistory.append("Diabetics, ")
        }
        if (hormonalIssuesCheckBox.isChecked) {
            medicalHistory.append("Hormonal Issues, ")
        }
        if (physicalInjuryCheckBox.isChecked) {
            medicalHistory.append("Physical Injury, ")
        }
        return medicalHistory.toString().trimEnd(',', ' ')
    }

    private fun getFamilyIncome(): String {
        // Get the selected family income
        return when {
            averageIncomeRadioButton.isChecked -> "Average"
            belowAverageIncomeRadioButton.isChecked -> "Below Average"
            aboveAverageIncomeRadioButton.isChecked -> "Above Average"
            else -> ""
        }
    }
}
