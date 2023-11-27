package com.example.vizitinecv.data

import android.content.Context
import androidx.core.content.edit

class AppPreferences(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "MyAppPreferences"
        private const val KEY_NOTES = "notes"
    }

    // Function to save a list of notes to preferences
    fun saveNotes(notes: List<String>) {
        sharedPreferences.edit {
            putString(KEY_NOTES, notes.joinToString(separator = ";"))
        }
    }

    // Function to retrieve a list of notes from preferences
    fun getNotes(): List<String> {
        val savedNotesString = sharedPreferences.getString(KEY_NOTES, "") ?: ""
        return savedNotesString.split(";")
    }

    // Add other preference-related functions as needed
}
