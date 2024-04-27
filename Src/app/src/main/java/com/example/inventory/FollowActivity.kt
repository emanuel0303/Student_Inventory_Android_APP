package com.example.inventory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class FollowActivity : AppCompatActivity() {

    private lateinit var followUpSession1Text: EditText
    private lateinit var followUpSession2Text: EditText
    private lateinit var followUpSession3Text: EditText
    private lateinit var followUpSession4Text: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followup)

        // Initialize views
        followUpSession1Text = findViewById(R.id.follow_up_session1_text)
        followUpSession2Text = findViewById(R.id.follow_up_session2_text)
        followUpSession3Text = findViewById(R.id.follow_up_session3_text)
        followUpSession4Text = findViewById(R.id.follow_up_session4_text)
        nextButton = findViewById(R.id.next_button)

        // Set onClickListener for Next button
        nextButton.setOnClickListener {
            // Check if all fields are filled
            if (areAllFieldsFilled()) {
                // Get user inputs
                val followUpSession1 = followUpSession1Text.text.toString()
                val followUpSession2 = followUpSession2Text.text.toString()
                val followUpSession3 = followUpSession3Text.text.toString()
                val followUpSession4 = followUpSession4Text.text.toString()

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
                val employmentStatus = intent.getStringExtra("employment_status")
                val jobStress = intent.getStringExtra("job_stress")
                val jobSatisfaction = intent.getStringExtra("job_satisfaction")
                val performanceDescription = intent.getStringExtra("performance_description")
                val occupation = intent.getStringExtra("occupation")
                val habits = intent.getStringExtra("habits")
                val health = intent.getStringExtra("health")
                val compatibility = intent.getStringExtra("compatibility")
                val kids = intent.getStringExtra("kids")
                val sexualSatisfaction = intent.getStringExtra("sexual_satisfaction")
                val smoking = intent.getBooleanExtra("smoking", false)
                val alcohol = intent.getBooleanExtra("alcohol", false)
                val drugs = intent.getBooleanExtra("drugs", false)
                val paanGutka = intent.getBooleanExtra("paanGutka", false)
                val otherHabits = intent.getStringExtra("otherHabits")
                val specificDetails = intent.getStringExtra("specificDetails")
                val likesDislikes = intent.getStringExtra("likesDislikes")
                val interests = intent.getStringExtra("interests")

                // Create Intent for the next activity
                val intent = Intent(this, ConsentMi::class.java)

                // Pass data to the next activity
                intent.apply {

                    // Pass the received data from previous activity
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
                    putExtra("smoking", smoking)
                    putExtra("alcohol", alcohol)
                    putExtra("drugs", drugs)
                    putExtra("paanGutka", paanGutka)
                    putExtra("otherHabits", otherHabits)
                    putExtra("specificDetails", specificDetails)
                    putExtra("likesDislikes", likesDislikes)
                    putExtra("interests", interests)
                    putExtra("follow_up_session1", followUpSession1)
                    putExtra("follow_up_session2", followUpSession2)
                    putExtra("follow_up_session3", followUpSession3)
                    putExtra("follow_up_session4", followUpSession4)

                }

                // Start the next activity
                startActivity(intent)
            } else {
                // If any field is empty, show a toast message
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to check if all fields are filled
    private fun areAllFieldsFilled(): Boolean {
        return (followUpSession1Text.text.isNotEmpty() &&
                followUpSession2Text.text.isNotEmpty() &&
                followUpSession3Text.text.isNotEmpty() &&
                followUpSession4Text.text.isNotEmpty())
    }
}
