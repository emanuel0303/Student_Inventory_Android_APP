// DatabaseHelper.kt
package com.example.inventory

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 2 // Increment the version number
        const val DATABASE_NAME = "Inventory.db"

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${Contract.InventoryEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${Contract.InventoryEntry.COLUMN_NAME_NAME} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_DOB} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_GENDER} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_AGE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_CITY} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_STATE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_PIN} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_EDUCATION} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_INFORMANT_NAME} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_CONCERN1} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_CONCERN2} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_CONCERN3} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_MODE_OF_ONSET} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_DURATION} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_SLEEP} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_APPETITE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_NATURE_OF_TREATMENT} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_MEDICINE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_DURATION_OF_TREATMENT} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_RESPONSE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FAMILY_HISTORY} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FAMILY_TYPE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_CONSANGUINITY} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_PARENTAL_MARRIAGE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_RESIDENCE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FAMILY_SIZE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FAMILY_INCOME} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_HEALTH_DETAILS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_TRAUMA_DETAILS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_EDUCATION_QUALIFICATION} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_REMARKS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_MENSTRUAL_HISTORY} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_HOMOSEXUALITY_RESPONSE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_LOVE_RELATIONSHIP_RESPONSE} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_EMPLOYMENT_STATUS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_JOB_STRESS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_JOB_SATISFACTION} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_PERFORMANCE_DESCRIPTION} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_OCCUPATION} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_HABITS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_HEALTH} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_COMPATIBILITY} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_KIDS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_SEXUAL_SATISFACTION} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_SMOKING} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_ALCOHOL} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_DRUGS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_PAAN_GUTKA} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_OTHER_HABITS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_SPECIFIC_DETAILS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_LIKES_DISLIKES} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_INTERESTS} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION1} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION2} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION3} TEXT," +
                    "${Contract.InventoryEntry.COLUMN_NAME_FOLLOW_UP_SESSION4} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${Contract.InventoryEntry.TABLE_NAME}"
    }
}
