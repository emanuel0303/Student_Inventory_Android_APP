package com.example.inventory

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.inventory.Contract.InventoryEntry

class MyDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertData(data: ContentValues): Long {
        val db = writableDatabase
        return db.insert(InventoryEntry.TABLE_NAME, null, data)
    }

    fun searchInventoryData(searchTerm: String): Cursor? {
        val db = readableDatabase
        val projection = arrayOf(
            InventoryEntry.COLUMN_NAME_NAME,
            InventoryEntry.COLUMN_NAME_DOB,
            InventoryEntry.COLUMN_NAME_GENDER,
            InventoryEntry.COLUMN_NAME_AGE,
            InventoryEntry.COLUMN_NAME_CITY,
            InventoryEntry.COLUMN_NAME_STATE,
            InventoryEntry.COLUMN_NAME_PIN,
            InventoryEntry.COLUMN_NAME_EDUCATION,
            InventoryEntry.COLUMN_NAME_INFORMANT_NAME,
            InventoryEntry.COLUMN_NAME_CONCERN1,
            InventoryEntry.COLUMN_NAME_CONCERN2,
            InventoryEntry.COLUMN_NAME_CONCERN3,
            InventoryEntry.COLUMN_NAME_MODE_OF_ONSET,
            InventoryEntry.COLUMN_NAME_DURATION,
            InventoryEntry.COLUMN_NAME_SLEEP,
            InventoryEntry.COLUMN_NAME_APPETITE,
            InventoryEntry.COLUMN_NAME_NATURE_OF_TREATMENT,
            InventoryEntry.COLUMN_NAME_MEDICINE,
            InventoryEntry.COLUMN_NAME_DURATION_OF_TREATMENT,
            InventoryEntry.COLUMN_NAME_RESPONSE,
            InventoryEntry.COLUMN_NAME_FAMILY_HISTORY,
            InventoryEntry.COLUMN_NAME_FAMILY_TYPE,
            InventoryEntry.COLUMN_NAME_CONSANGUINITY,
            InventoryEntry.COLUMN_NAME_PARENTAL_MARRIAGE,
            InventoryEntry.COLUMN_NAME_RESIDENCE,
            InventoryEntry.COLUMN_NAME_FAMILY_SIZE,
            InventoryEntry.COLUMN_NAME_FAMILY_INCOME,
            InventoryEntry.COLUMN_NAME_HEALTH_DETAILS,
            InventoryEntry.COLUMN_NAME_TRAUMA_DETAILS,
            InventoryEntry.COLUMN_NAME_EDUCATION_QUALIFICATION,
            InventoryEntry.COLUMN_NAME_REMARKS,
            InventoryEntry.COLUMN_NAME_MENSTRUAL_HISTORY,
            InventoryEntry.COLUMN_NAME_HOMOSEXUALITY_RESPONSE,
            InventoryEntry.COLUMN_NAME_LOVE_RELATIONSHIP_RESPONSE,
            InventoryEntry.COLUMN_NAME_EMPLOYMENT_STATUS,
            InventoryEntry.COLUMN_NAME_JOB_STRESS,
            InventoryEntry.COLUMN_NAME_JOB_SATISFACTION,
            InventoryEntry.COLUMN_NAME_PERFORMANCE_DESCRIPTION,
            InventoryEntry.COLUMN_NAME_OCCUPATION,
            InventoryEntry.COLUMN_NAME_HABITS,
            InventoryEntry.COLUMN_NAME_HEALTH,
            InventoryEntry.COLUMN_NAME_COMPATIBILITY,
            InventoryEntry.COLUMN_NAME_KIDS,
            InventoryEntry.COLUMN_NAME_SEXUAL_SATISFACTION,
            InventoryEntry.COLUMN_NAME_SMOKING,
            InventoryEntry.COLUMN_NAME_ALCOHOL,
            InventoryEntry.COLUMN_NAME_DRUGS,
            InventoryEntry.COLUMN_NAME_PAAN_GUTKA,
            InventoryEntry.COLUMN_NAME_OTHER_HABITS,
            InventoryEntry.COLUMN_NAME_SPECIFIC_DETAILS,
            InventoryEntry.COLUMN_NAME_LIKES_DISLIKES,
            InventoryEntry.COLUMN_NAME_INTERESTS,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION1,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION2,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION3,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION4
        )

        val selection = "${InventoryEntry.COLUMN_NAME_NAME} LIKE ?"
        val selectionArgs = arrayOf("%$searchTerm%")

        return try {
            db.query(
                InventoryEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
            )
        }catch (e: SQLiteException){
            e.printStackTrace()
            null
        }
    }


    fun getAllInventoryData(): Cursor? {
        val db = readableDatabase
        val projection = arrayOf(
            InventoryEntry.COLUMN_NAME_NAME,
            InventoryEntry.COLUMN_NAME_DOB,
            InventoryEntry.COLUMN_NAME_GENDER,
            InventoryEntry.COLUMN_NAME_AGE,
            InventoryEntry.COLUMN_NAME_CITY,
            InventoryEntry.COLUMN_NAME_STATE,
            InventoryEntry.COLUMN_NAME_PIN,
            InventoryEntry.COLUMN_NAME_EDUCATION,
            InventoryEntry.COLUMN_NAME_INFORMANT_NAME,
            InventoryEntry.COLUMN_NAME_CONCERN1,
            InventoryEntry.COLUMN_NAME_CONCERN2,
            InventoryEntry.COLUMN_NAME_CONCERN3,
            InventoryEntry.COLUMN_NAME_MODE_OF_ONSET,
            InventoryEntry.COLUMN_NAME_DURATION,
            InventoryEntry.COLUMN_NAME_SLEEP,
            InventoryEntry.COLUMN_NAME_APPETITE,
            InventoryEntry.COLUMN_NAME_NATURE_OF_TREATMENT,
            InventoryEntry.COLUMN_NAME_MEDICINE,
            InventoryEntry.COLUMN_NAME_DURATION_OF_TREATMENT,
            InventoryEntry.COLUMN_NAME_RESPONSE,
            InventoryEntry.COLUMN_NAME_FAMILY_HISTORY,
            InventoryEntry.COLUMN_NAME_FAMILY_TYPE,
            InventoryEntry.COLUMN_NAME_CONSANGUINITY,
            InventoryEntry.COLUMN_NAME_PARENTAL_MARRIAGE,
            InventoryEntry.COLUMN_NAME_RESIDENCE,
            InventoryEntry.COLUMN_NAME_FAMILY_SIZE,
            InventoryEntry.COLUMN_NAME_FAMILY_INCOME,
            InventoryEntry.COLUMN_NAME_HEALTH_DETAILS,
            InventoryEntry.COLUMN_NAME_TRAUMA_DETAILS,
            InventoryEntry.COLUMN_NAME_EDUCATION_QUALIFICATION,
            InventoryEntry.COLUMN_NAME_REMARKS,
            InventoryEntry.COLUMN_NAME_MENSTRUAL_HISTORY,
            InventoryEntry.COLUMN_NAME_HOMOSEXUALITY_RESPONSE,
            InventoryEntry.COLUMN_NAME_LOVE_RELATIONSHIP_RESPONSE,
            InventoryEntry.COLUMN_NAME_EMPLOYMENT_STATUS,
            InventoryEntry.COLUMN_NAME_JOB_STRESS,
            InventoryEntry.COLUMN_NAME_JOB_SATISFACTION,
            InventoryEntry.COLUMN_NAME_PERFORMANCE_DESCRIPTION,
            InventoryEntry.COLUMN_NAME_OCCUPATION,
            InventoryEntry.COLUMN_NAME_HABITS,
            InventoryEntry.COLUMN_NAME_HEALTH,
            InventoryEntry.COLUMN_NAME_COMPATIBILITY,
            InventoryEntry.COLUMN_NAME_KIDS,
            InventoryEntry.COLUMN_NAME_SEXUAL_SATISFACTION,
            InventoryEntry.COLUMN_NAME_SMOKING,
            InventoryEntry.COLUMN_NAME_ALCOHOL,
            InventoryEntry.COLUMN_NAME_DRUGS,
            InventoryEntry.COLUMN_NAME_PAAN_GUTKA,
            InventoryEntry.COLUMN_NAME_OTHER_HABITS,
            InventoryEntry.COLUMN_NAME_SPECIFIC_DETAILS,
            InventoryEntry.COLUMN_NAME_LIKES_DISLIKES,
            InventoryEntry.COLUMN_NAME_INTERESTS,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION1,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION2,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION3,
            InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION4
        )

        return try {
            db.query(
                InventoryEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )
        }catch (e : SQLiteException){
            e.printStackTrace()
            null
        }
    }



    companion object {
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "Inventory.db"

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${InventoryEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${InventoryEntry.COLUMN_NAME_NAME} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_DOB} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_GENDER} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_AGE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_CITY} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_STATE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_PIN} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_EDUCATION} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_INFORMANT_NAME} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_CONCERN1} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_CONCERN2} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_CONCERN3} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_MODE_OF_ONSET} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_DURATION} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_SLEEP} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_APPETITE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_NATURE_OF_TREATMENT} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_MEDICINE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_DURATION_OF_TREATMENT} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_RESPONSE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FAMILY_HISTORY} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FAMILY_TYPE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_CONSANGUINITY} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_PARENTAL_MARRIAGE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_RESIDENCE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FAMILY_SIZE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FAMILY_INCOME} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_HEALTH_DETAILS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_TRAUMA_DETAILS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_EDUCATION_QUALIFICATION} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_REMARKS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_MENSTRUAL_HISTORY} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_HOMOSEXUALITY_RESPONSE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_LOVE_RELATIONSHIP_RESPONSE} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_EMPLOYMENT_STATUS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_JOB_STRESS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_JOB_SATISFACTION} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_PERFORMANCE_DESCRIPTION} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_OCCUPATION} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_HABITS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_HEALTH} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_COMPATIBILITY} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_KIDS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_SEXUAL_SATISFACTION} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_SMOKING} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_ALCOHOL} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_DRUGS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_PAAN_GUTKA} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_OTHER_HABITS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_SPECIFIC_DETAILS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_LIKES_DISLIKES} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_INTERESTS} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION1} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION2} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION3} TEXT," +
                    "${InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION4} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${InventoryEntry.TABLE_NAME}"
    }
}
