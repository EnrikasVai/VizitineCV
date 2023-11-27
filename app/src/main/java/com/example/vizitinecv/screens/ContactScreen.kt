package com.example.vizitinecv.screens

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vizitinecv.R
import com.example.vizitinecv.data.ContactFormData
import com.example.vizitinecv.ui.theme.Blue


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavHostController) {
    var formData by remember { mutableStateOf(ContactFormData("", "", "")) }
    var nameError by remember { mutableStateOf(false) }
    var subjectError by remember { mutableStateOf(false) }
    var messageError by remember { mutableStateOf(false) }
    val context = LocalContext.current // Access the LocalContext

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.contact_me), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
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
                    OutlinedTextField(
                        value = formData.name,
                        onValueChange = {
                            formData = formData.copy(name = it)
                            nameError = it.isBlank()
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = if (nameError) Color.Red else Blue,
                            unfocusedBorderColor = if (nameError) Color.Red else Color.Gray
                        ),
                        label = { Text(stringResource(R.string.name)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = formData.subject,
                        onValueChange = {
                            formData = formData.copy(subject = it)
                            subjectError = it.isBlank()
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = if (subjectError) Color.Red else Blue,
                            unfocusedBorderColor = if (subjectError) Color.Red else Color.Gray
                        ),
                        label = { Text(stringResource(R.string.subject)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = formData.message,
                        onValueChange = {
                            formData = formData.copy(message = it)
                            messageError = it.isBlank()
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = if (messageError) Color.Red else Blue,
                            unfocusedBorderColor = if (messageError) Color.Red else Color.Gray
                        ),
                        label = { Text(stringResource(R.string.message)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }

                item {
                    // Submit button with validation
                    Button(
                        onClick = {
                            nameError = formData.name.isBlank()
                            subjectError = formData.subject.isBlank()
                            messageError = formData.message.isBlank()

                            if (isFormValid(formData)) {
                                sendEmail(formData, context)
                                formData = ContactFormData("", "", "")
                            } else {
                                // Show error message using Toast
                                Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 8.dp)
                    ) {
                        Text(stringResource(R.string.send_email))
                    }
                }
            }
        }
    )
}

private fun isFormValid(formData: ContactFormData): Boolean {
    return formData.name.isNotBlank() &&
            formData.subject.isNotBlank() &&
            formData.message.isNotBlank()
}

// Placeholder function for sending the email
private fun sendEmail(formData: ContactFormData, context: Context) {
    val emailIntent = Intent(Intent.ACTION_SENDTO)
    emailIntent.data = Uri.parse("mailto:") // This ensures only email apps respond

    emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("enrikas1010@gmail.com")) // Replace with your recipient email address
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, formData.subject)
    emailIntent.putExtra(Intent.EXTRA_TEXT, "I'm: ${formData.name}\n\n ${formData.message}")

    try {
        context.startActivity(emailIntent)

    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No email client found", Toast.LENGTH_SHORT).show()
    }
}