package com.example.inventory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HabitsActivity : AppCompatActivity() {

    private lateinit var smokingCheckBox: CheckBox
    private lateinit var alcoholCheckBox: CheckBox
    private lateinit var drugsCheckBox: CheckBox
    private lateinit var paanGutkaCheckBox: CheckBox
    private lateinit var otherHabitsEditText: EditText
    private lateinit var specificDetailsEditText: EditText
    private lateinit var likesDislikesEditText: EditText
    private lateinit var interestsEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habits)

        // Initialize views
        smokingCheckBox = findViewById(R.id.smoking_checkbox)
        alcoholCheckBox = findViewById(R.id.alcohol_checkbox)
        drugsCheckBox = findViewById(R.id.drugs_checkbox)
        paanGutkaCheckBox = findViewById(R.id.paan_gutka_checkbox)
        otherHabitsEditText = findViewById(R.id.other_habits_edit_text)
        specificDetailsEditText = findViewById(R.id.specific_details_edit_text)
        likesDislikesEditText = findViewById(R.id.likes_dislikes_edit_text)
        interestsEditText = findViewById(R.id.interests_edit_text)
        nextButton = findViewById(R.id.next_button)

        // Set onClickListener for Next button
        nextButton.setOnClickListener {
            // Check if all fields are filled
            if (areAllFieldsFilled()) {
                // Get user inputs
                val smoking = smokingCheckBox.isChecked
                val alcohol = alcoholCheckBox.isChecked
                val drugs = drugsCheckBox.isChecked
                val paanGutka = paanGutkaCheckBox.isChecked
                val otherHabits = otherHabitsEditText.text.toString()
                val specificDetails = specificDetailsEditText.text.toString()
                val likesDislikes = likesDislikesEditText.text.toString()
                val interests = interestsEditText.text.toString()

                // Retrieve intent extras with null checks
                val name = intent.getStringExtra("name") ?: ""
                val dob = intent.getStringExtra("dob") ?: ""
                val gender = intent.getStringExtra("gender") ?: ""
                val age = intent.getStringExtra("age") ?: ""
                val address = intent.getStringExtra("address") ?: ""
                val email = intent.getStringExtra("email") ?: ""
                val mobilenum = intent.getStringExtra("mobilenum") ?: ""
                val education = intent.getStringExtra("education") ?: ""
                val informantName = intent.getStringExtra("informantName") ?: ""
                val concern1 = intent.getStringExtra("concern1") ?: ""
                val concern2 = intent.getStringExtra("concern2") ?: ""
                val concern3 = intent.getStringExtra("concern3") ?: ""
                val modeOfOnset = intent.getStringExtra("modeOfOnset") ?: ""
                val duration = intent.getStringExtra("duration") ?: ""
                val sleep = intent.getStringExtra("sleep") ?: ""
                val appetite = intent.getStringExtra("appetite") ?: ""
                val natureOfTreatment = intent.getStringExtra("natureOfTreatment") ?: ""
                val medicine = intent.getStringExtra("medicine") ?: ""
                val treatmentDuration = intent.getStringExtra("treatmentDuration") ?: ""
                val medicalHistory = intent.getStringExtra("medicalHistory") ?: ""
                val medicalHistoryDescription = intent.getStringExtra("medicalHistoryDescription") ?: ""
                val response = intent.getStringExtra("response") ?: ""
                val familyHistory = intent.getStringExtra("familyHistory") ?: ""
                val familyType = intent.getStringExtra("familyType") ?: ""
                val consanguinity = intent.getStringExtra("consanguinity") ?: ""
                val parentalMarriage = intent.getStringExtra("parentalMarriage") ?: ""
                val residence = intent.getStringExtra("residence") ?: ""
                val familySize = intent.getStringExtra("familySize") ?: ""
                val familyIncome = intent.getStringExtra("familyIncome") ?: ""
                val healthDetails = intent.getStringExtra("health_details") ?: ""
                val traumaDetails = intent.getStringExtra("trauma_details") ?: ""
                val educationQualification = intent.getStringExtra("education_qualification") ?: ""
                val remarks = intent.getStringExtra("remarks") ?: ""
                val menstrualHistory = intent.getStringExtra("menstrual_history") ?: ""
                val homosexualityResponse = intent.getStringExtra("homosexuality_response") ?: ""
                val loveRelationshipResponse = intent.getStringExtra("love_relationship_response") ?: ""
                val employmentStatus = intent.getStringExtra("employment_status") ?: ""
                val jobStress = intent.getStringExtra("job_stress") ?: ""
                val jobSatisfaction = intent.getStringExtra("job_satisfaction") ?: ""
                val performanceDescription = intent.getStringExtra("performance_description") ?: ""
                val occupation = intent.getStringExtra("occupation") ?: ""
                val habits = intent.getStringExtra("habits") ?: ""
                val health = intent.getStringExtra("health") ?: ""
                val compatibility = intent.getStringExtra("compatibility") ?: ""
                val kids = intent.getStringExtra("kids") ?: ""
                val sexualSatisfaction = intent.getStringExtra("sexual_satisfaction") ?: ""

                // Create Intent for the next activity
                val intent = Intent(this, FollowActivity::class.java)

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
                    putExtra("smoking", smoking)
                    putExtra("alcohol", alcohol)
                    putExtra("drugs", drugs)
                    putExtra("paanGutka", paanGutka)
                    putExtra("otherHabits", otherHabits)
                    putExtra("specificDetails", specificDetails)
                    putExtra("likesDislikes", likesDislikes)
                    putExtra("interests", interests)
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
        return (otherHabitsEditText.text.isNotEmpty() &&
                specificDetailsEditText.text.isNotEmpty() &&
                likesDislikesEditText.text.isNotEmpty() &&
                interestsEditText.text.isNotEmpty())
    }
}
