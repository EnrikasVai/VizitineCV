package com.example.vizitinecv.data

import android.content.Context
import androidx.core.content.edit

class AppPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveUserInfo(name: String, email: String, address: String, description: String) {
        sharedPreferences.edit {
            putString(KEY_NAME, name)
            putString(KEY_EMAIL, email)
            putString(KEY_ADDRESS, address)
            putString(KEY_DESCRIPTION, description)
        }
    }

    fun getUserInfo(): UserInfo {
        return UserInfo(
            sharedPreferences.getString(KEY_NAME, DEFAULT_NAME) ?: DEFAULT_NAME,
            sharedPreferences.getString(KEY_EMAIL, DEFAULT_EMAIL) ?: DEFAULT_EMAIL,
            sharedPreferences.getString(KEY_ADDRESS, DEFAULT_ADDRESS) ?: DEFAULT_ADDRESS,
            sharedPreferences.getString(KEY_DESCRIPTION, DEFAULT_DESCRIPTION) ?: DEFAULT_DESCRIPTION
        )
    }

    companion object {
        private const val PREFS_NAME = "MyAppPreferences"
        private const val KEY_NAME = "user_name"
        private const val KEY_EMAIL = "user_email"
        private const val KEY_ADDRESS = "user_address"
        private const val KEY_DESCRIPTION = "user_description"

        // Default values
        private const val DEFAULT_NAME = "Enrikas Vaičiulis"
        private const val DEFAULT_EMAIL = "enrikas1010@gmail.com"
        private const val DEFAULT_ADDRESS = "Alytus"
        private const val DEFAULT_DESCRIPTION = "Aprasymas"
    }
}

data class UserInfo(val name: String, val email: String, val address: String, val description: String)