package com.example.inventory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OccupationActivity : AppCompatActivity() {

    private lateinit var employmentStatusSpinner: Spinner
    private lateinit var jobStressSpinner: Spinner
    private lateinit var jobSatisfactionSpinner: Spinner
    private lateinit var performanceDescriptionEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var occupationEditText: EditText
    private lateinit var educationEditText: EditText
    private lateinit var habitsEditText: EditText
    private lateinit var healthEditText: EditText
    private lateinit var compatibilityEditText: EditText
    private lateinit var kidsEditText: EditText
    private lateinit var sexualSatisfactionEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_occupation)

        // Initialize views and set click listener for Next button using apply
        findViewById<Spinner>(R.id.employment_status_spinner).apply { employmentStatusSpinner = this }
        findViewById<Spinner>(R.id.job_stress_spinner).apply { jobStressSpinner = this }
        findViewById<Spinner>(R.id.job_satisfaction_spinner).apply { jobSatisfactionSpinner = this }
        findViewById<EditText>(R.id.performance_description).apply { performanceDescriptionEditText = this }
        findViewById<EditText>(R.id.age_edit_text).apply { ageEditText = this }
        findViewById<EditText>(R.id.occupation_edit_text).apply { occupationEditText = this }
        findViewById<EditText>(R.id.education_edit_text).apply { educationEditText = this }
        findViewById<EditText>(R.id.habits_edit_text).apply { habitsEditText = this }
        findViewById<EditText>(R.id.health_edit_text).apply { healthEditText = this }
        findViewById<EditText>(R.id.compatibility_edit_text).apply { compatibilityEditText = this }
        findViewById<EditText>(R.id.kids_edit_text).apply { kidsEditText = this }
        findViewById<EditText>(R.id.sexual_satisfaction_edit_text).apply { sexualSatisfactionEditText = this }

        // Retrieve data sent from EducationActivity
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
        val treatmentDuration = intent.getStringExtra("treatmentDuration")
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
        val healthDetails = intent.getStringExtra("health_details")
        val traumaDetails = intent.getStringExtra("trauma_details")
        val educationQualification = intent.getStringExtra("education_qualification")
        val remarks = intent.getStringExtra("remarks")
        val menstrualHistory = intent.getStringExtra("menstrual_history")
        val homosexualityResponse = intent.getStringExtra("homosexuality_response")
        val loveRelationshipResponse = intent.getStringExtra("love_relationship_response")

        findViewById<Button>(R.id.next_button).apply {
            nextButton = this
            setOnClickListener {
                // Check if all fields are filled
                if (areAllFieldsFilled()) {
                    // Get user inputs
                    val employmentStatus = employmentStatusSpinner.selectedItem.toString()
                    val jobStress = jobStressSpinner.selectedItem.toString()
                    val jobSatisfaction = jobSatisfactionSpinner.selectedItem.toString()
                    val performanceDescription = performanceDescriptionEditText.text.toString()
                    val age = ageEditText.text.toString()
                    val occupation = occupationEditText.text.toString()
                    val education = educationEditText.text.toString()
                    val habits = habitsEditText.text.toString()
                    val health = healthEditText.text.toString()
                    val compatibility = compatibilityEditText.text.toString()
                    val kids = kidsEditText.text.toString()
                    val sexualSatisfaction = sexualSatisfactionEditText.text.toString()

                    // Create an Intent to navigate to the next activity
                    val intent = Intent(this@OccupationActivity, HabitsActivity::class.java)
                    // Pass data to the next activity using Intent extras
                    intent.apply {
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
                        putExtra("treatmentDuration", treatmentDuration)
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
                        putExtra("health_details", healthDetails)
                        putExtra("trauma_details", traumaDetails)
                        putExtra("education_qualification", educationQualification)
                        putExtra("remarks", remarks)
                        putExtra("menstrual_history", menstrualHistory)
                        putExtra("homosexuality_response", homosexualityResponse)
                        putExtra("love_relationship_response", loveRelationshipResponse)
                        putExtra("employment_status", employmentStatus)
                        putExtra("job_stress", jobStress)
                        putExtra("job_satisfaction", jobSatisfaction)
                        putExtra("performance_description", performanceDescription)
                        putExtra("occupation", occupation)
                        putExtra("habits", habits)
                        putExtra("health", health)
                        putExtra("compatibility", compatibility)
                        putExtra("kids", kids)
                        putExtra("sexual_satisfaction", sexualSatisfaction)
                    }
                    // Start the next activity
                    startActivity(intent)
                } else {
                    // If any field is empty, show a toast message
                    Toast.makeText(this@OccupationActivity, "Please fill all details", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Function to check if all fields are filled
    private fun areAllFieldsFilled(): Boolean {
        return (ageEditText.text.isNotEmpty() &&
                occupationEditText.text.isNotEmpty() &&
                educationEditText.text.isNotEmpty() &&
                performanceDescriptionEditText.text.isNotEmpty() &&
                habitsEditText.text.isNotEmpty() &&
                healthEditText.text.isNotEmpty() &&
                compatibilityEditText.text.isNotEmpty() &&
                kidsEditText.text.isNotEmpty() &&
                sexualSatisfactionEditText.text.isNotEmpty())
    }
}
