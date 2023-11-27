package com.example.vizitinecv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vizitinecv.data.AppPreferences
import com.example.vizitinecv.screens.CVScreen
import com.example.vizitinecv.screens.ContactScreen
import com.example.vizitinecv.screens.HomeScreen
import com.example.vizitinecv.screens.Portfolio
import com.example.vizitinecv.screens.QR
import com.example.vizitinecv.ui.theme.VizitineCVTheme

class MainActivity : ComponentActivity() {
    private val appPreferences by lazy { AppPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VizitineCVTheme {
                val navController = rememberNavController()

                // Set up the NavHost with two composable screens
                NavHost(
                    navController = navController,
                    startDestination = "screen1"
                ) {
                    composable("screen1") {
                        HomeScreen(navController = navController, activity = LocalContext.current as ComponentActivity)
                    }
                    composable("screen2") {
                        CVScreen(navController = navController, appPreferences = appPreferences)
                    }
                    composable("screen3") {
                        ContactScreen(navController = navController)
                    }
                    composable("screen4") {
                        Portfolio(navController = navController)
                    }
                    composable("screen5") {
                        QR(navController = navController)
                    }
            }
        }
    }
}}