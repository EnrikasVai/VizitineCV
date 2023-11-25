package com.example.vizitinecv.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vizitinecv.data.AppPreferences

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVScreen(navController: NavHostController, appPreferences: AppPreferences) {
    var isEditMode by remember { mutableStateOf(false) }
    var editedName by remember { mutableStateOf(appPreferences.getUserInfo().name) }
    var editedEmail by remember { mutableStateOf(appPreferences.getUserInfo().email) }
    var editedAddress by remember { mutableStateOf(appPreferences.getUserInfo().address) }
    var editedDescription by remember { mutableStateOf(appPreferences.getUserInfo().description) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text ("CV") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Add space between top app bar and the list
                item {
                    Spacer(modifier = Modifier.height(60.dp))
                }
                item {
                    // Display editable information when in edit mode
                    if (isEditMode) {
                        // Editable fields
                        OutlinedTextField(
                            value = editedName,
                            onValueChange = { editedName = it },
                            label = { Text("Name") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )

                        OutlinedTextField(
                            value = editedEmail,
                            onValueChange = { editedEmail = it },
                            label = { Text("Email") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )

                        OutlinedTextField(
                            value = editedAddress,
                            onValueChange = { editedAddress = it },
                            label = { Text("Address") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )

                        OutlinedTextField(
                            value = editedDescription,
                            onValueChange = { editedDescription = it },
                            label = { Text("Short Description") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )
                    } else {
                        // Display information in view mode
                        Text(text = "Name: $editedName", fontWeight = FontWeight.Bold)
                        Text(text = "Email: $editedEmail")
                        Text(text = "Address: $editedAddress")
                        Text(text = "Short Description: $editedDescription")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Toggle edit mode button
                    Button(
                        onClick = {
                            isEditMode = !isEditMode
                            appPreferences.saveUserInfo(editedName, editedEmail, editedAddress, editedDescription)
                                  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = if (isEditMode) "Save Information" else "Modify Information", color = Color.White)
                        }
                    }
                }
            }
        }
    )
}