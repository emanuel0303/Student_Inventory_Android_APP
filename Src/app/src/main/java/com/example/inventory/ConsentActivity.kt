package com.example.inventory

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class ConsentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consent)

        val checkBoxAgree = findViewById<CheckBox>(R.id.checkBoxAgree)
        val buttonSave = findViewById<Button>(R.id.buttonSave)

        checkBoxAgree.setOnCheckedChangeListener { _, isChecked ->
            buttonSave.isEnabled = isChecked
        }

        buttonSave.setOnClickListener {
            if (checkBoxAgree.isChecked) {
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
                val response = intent.getStringExtra("response")
                val familyHistory = intent.getStringExtra("familyHistory")
                val familyType = intent.getStringExtra("familyType")
                val consanguinity = intent.getStringExtra("consanguinity")
                val parentalMarriage = intent.getStringExtra("parentalMarriage")
                val residence = intent.getStringExtra("residence")
                val familySize = intent.getStringExtra("familySize")
                val familyIncome = intent.getStringExtra("familyIncome")
                val healthDetails = intent.getStringExtra("healthDetails")
                val traumaDetails = intent.getStringExtra("traumaDetails")
                val educationQualification = intent.getStringExtra("educationQualification")
                val remarks = intent.getStringExtra("remarks")
                val menstrualHistory = intent.getStringExtra("menstrualHistory")
                val homosexualityResponse = intent.getStringExtra("homosexualityResponse")
                val loveRelationshipResponse = intent.getStringExtra("loveRelationshipResponse")
                val employmentStatus = intent.getStringExtra("employmentStatus")
                val jobStress = intent.getStringExtra("jobStress")
                val jobSatisfaction = intent.getStringExtra("jobSatisfaction")
                val performanceDescription = intent.getStringExtra("performanceDescription")
                val occupation = intent.getStringExtra("occupation")
                val habits = intent.getStringExtra("habits")
                val health = intent.getStringExtra("health")
                val compatibility = intent.getStringExtra("compatibility")
                val kids = intent.getStringExtra("kids")
                val sexualSatisfaction = intent.getStringExtra("sexualSatisfaction")
                val smoking = intent.getBooleanExtra("smoking", false)
                val alcohol = intent.getBooleanExtra("alcohol", false)
                val drugs = intent.getBooleanExtra("drugs", false)
                val paanGutka = intent.getBooleanExtra("paanGutka", false)
                val otherHabits = intent.getStringExtra("otherHabits")
                val specificDetails = intent.getStringExtra("specificDetails")
                val likesDislikes = intent.getStringExtra("likesDislikes")
                val interests = intent.getStringExtra("interests")
                val followUpSession1 = intent.getStringExtra("follow_up_session1")
                val followUpSession2 = intent.getStringExtra("follow_up_session2")
                val followUpSession3 = intent.getStringExtra("follow_up_session3")
                val followUpSession4 = intent.getStringExtra("follow_up_session4")

                saveDataToFirebase(
                    name, dob, gender, age, address, email, mobilenum, education, informantName, concern1,
                    concern2, concern3, modeOfOnset, duration, sleep, appetite, natureOfTreatment,
                    medicine, treatmentDuration, response,
                    familyHistory, familyType, consanguinity, parentalMarriage, residence, familySize,
                    familyIncome, healthDetails, traumaDetails, educationQualification, remarks,
                    menstrualHistory, homosexualityResponse, loveRelationshipResponse, employmentStatus,
                    jobStress, jobSatisfaction, performanceDescription, occupation, habits, health,
                    compatibility, kids, sexualSatisfaction, smoking, alcohol, drugs, paanGutka,
                    otherHabits, specificDetails, likesDislikes, interests, followUpSession1, followUpSession2,
                    followUpSession3, followUpSession4
                )
                Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please agree to continue", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun saveDataToFirebase(
        name: String?, dob: String?, gender: String?, age: String?, city: String?,
        state: String?, pin: String?, education: String?, informantName: String?, concern1: String?,
        concern2: String?, concern3: String?, modeOfOnset: String?, duration: String?, sleep: String?,
        appetite: String?, natureOfTreatment: String?, medicine: String?, treatmentDuration: String?, response: String?,
        familyHistory: String?, familyType: String?, consanguinity: String?, parentalMarriage: String?,
        residence: String?, familySize: String?, familyIncome: String?, healthDetails: String?,
        traumaDetails: String?, educationQualification: String?, remarks: String?,
        menstrualHistory: String?, homosexualityResponse: String?, loveRelationshipResponse: String?,
        employmentStatus: String?, jobStress: String?, jobSatisfaction: String?,
        performanceDescription: String?, occupation: String?, habits: String?, health: String?,
        compatibility: String?, kids: String?, sexualSatisfaction: String?, smoking: Boolean?,
        alcohol: Boolean?, drugs: Boolean?, paanGutka: Boolean?, otherHabits: String?,
        specificDetails: String?, likesDislikes: String?, interests: String?, followUpSession1: String?,
        followUpSession2: String?, followUpSession3: String?, followUpSession4: String?
    ) {
        // Initialize Firebase database reference
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("users") // Change "inventory_data" to your desired node name

        // Create a HashMap to store user data
        val userData = hashMapOf<String, Any?>(
            "name" to name,
            "dob" to dob,
            "gender" to gender,
            "age" to age,
            "city" to city,
            "state" to state,
            "pin" to pin,
            "education" to education,
            "informantName" to informantName,
            "concern1" to concern1,
            "concern2" to concern2,
            "concern3" to concern3,
            "modeOfOnset" to modeOfOnset,
            "duration" to duration,
            "sleep" to sleep,
            "appetite" to appetite,
            "natureOfTreatment" to natureOfTreatment,
            "medicine" to medicine,
            "treatmentDuration" to treatmentDuration,
            "response" to response,
            "familyHistory" to familyHistory,
            "familyType" to familyType,
            "consanguinity" to consanguinity,
            "parentalMarriage" to parentalMarriage,
            "residence" to residence,
            "familySize" to familySize,
            "familyIncome" to familyIncome,
            "healthDetails" to healthDetails,
            "traumaDetails" to traumaDetails,
            "educationQualification" to educationQualification,
            "remarks" to remarks,
            "menstrualHistory" to menstrualHistory,
            "homosexualityResponse" to homosexualityResponse,
            "loveRelationshipResponse" to loveRelationshipResponse,
            "employmentStatus" to employmentStatus,
            "jobStress" to jobStress,
            "jobSatisfaction" to jobSatisfaction,
            "performanceDescription" to performanceDescription,
            "occupation" to occupation,
            "habits" to habits,
            "health" to health,
            "compatibility" to compatibility,
            "kids" to kids,
            "sexualSatisfaction" to sexualSatisfaction,
            "smoking" to smoking,
            "alcohol" to alcohol,
            "drugs" to drugs,
            "paanGutka" to paanGutka,
            "otherHabits" to otherHabits,
            "specificDetails" to specificDetails,
            "likesDislikes" to likesDislikes,
            "interests" to interests,
            "followUpSession1" to followUpSession1,
            "followUpSession2" to followUpSession2,
            "followUpSession3" to followUpSession3,
            "followUpSession4" to followUpSession4
        )

        // Push the data to the database
        reference.push().setValue(userData)
            .addOnSuccessListener {
                Toast.makeText(this, "Data saved to Firebase", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to write data to Firebase", Toast.LENGTH_SHORT).show()
            }
    }

    companion object {
        private const val PERMISSION_CODE = 1000
    }
}
