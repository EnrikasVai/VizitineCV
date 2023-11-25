package com.example.vizitinecv.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vizitinecv.data.ContactFormData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavHostController) {
    var formData by remember { mutableStateOf(ContactFormData("", "", "", "")) }
    var isEmailValid by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact Me") },
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
                item {
                    Spacer(modifier = Modifier.height(60.dp))
                }

                item {
                    // Form fields with validation
                    TextField(
                        value = formData.name,
                        onValueChange = { formData = formData.copy(name = it) },
                        label = { Text("Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    TextField(
                        value = formData.subject,
                        onValueChange = { formData = formData.copy(subject = it) },
                        label = { Text("Subject") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = formData.email,
                        onValueChange = {
                            formData = formData.copy(email = it)
                            isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()
                        },
                        label = { Text("Email") },
                        isError = !isEmailValid,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    TextField(
                        value = formData.message,
                        onValueChange = { formData = formData.copy(message = it) },
                        label = { Text("Message") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }

                item {
                    // Validation messages
                    if (!isEmailValid) {
                        Text("Invalid email format", color = Color.Red)
                    }
                }

                item {
                    // Submit button with validation
                    Button(
                        onClick = {
                            if (isFormValid(formData)) {
                                sendEmail(formData)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 8.dp)
                    ) {
                        Text("Submit")
                    }
                }
            }
        }
    )
}

private fun isFormValid(formData: ContactFormData): Boolean {
    return formData.name.isNotBlank() &&
            formData.subject.isNotBlank() &&
            formData.email.isNotBlank() &&
            android.util.Patterns.EMAIL_ADDRESS.matcher(formData.email).matches() &&
            formData.message.isNotBlank()
}

// Placeholder function for sending the email
private fun sendEmail(formData: ContactFormData) {
    // Implement your email sending logic here
    println("Sending email to enrikas1010@gmail.com:")
    println("Name: ${formData.name}")
    println("Subject: ${formData.subject}")
    println("Email: ${formData.email}")
    println("Message: ${formData.message}")
}