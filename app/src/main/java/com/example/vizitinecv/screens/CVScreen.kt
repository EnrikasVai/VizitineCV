package com.example.vizitinecv.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vizitinecv.R
import com.example.vizitinecv.data.AppPreferences

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVScreen(navController: NavHostController, appPreferences: AppPreferences) {


    var notesListState by remember { mutableStateOf(appPreferences.getNotes().toMutableList()) }
    var isAddingNotes by remember { mutableStateOf(false) }
    var addingNotesTextField by remember { mutableStateOf("") }




    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text (
                        text = stringResource(R.string.cv),
                        color = Color.White)
                        },
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
                // Add space between top app bar and the list
                item {
                    Spacer(modifier = Modifier.height(60.dp))
                }
                item {
                    // Display information in a card
                    Card(
                        border = BorderStroke(1.dp, Color.Black),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.basic_information),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp, // Adjust the font size as needed
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(16.dp))


                            // Display information in view mode
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(R.string.name_2))
                                    }
                                    append(stringResource(R.string.myName))
                                }
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(R.string.email))
                                    }
                                    append(stringResource(R.string.Email))
                                }
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(R.string.address))
                                    }
                                    append(stringResource(R.string.alytus))
                                }
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(R.string.about_me))
                                    }
                                    append(stringResource(R.string.AboutMeShort))
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                    }
                }
                item {
                    Card(
                        border = BorderStroke(1.dp, Color.Black),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.education),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp, // Adjust the font size as needed
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = stringResource(R.string.bachelors_degree),
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp, // Adjust the font size as needed
                            )
                            Text(
                                text = stringResource(R.string.vilnius_tech_2020_2024)
                            )
                        }
                    }

                }
                item {
                    Card(
                        border = BorderStroke(1.dp, Color.Black),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.job_experiences),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp, // Adjust the font size as needed
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = stringResource(R.string.administrator),
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp, // Adjust the font size as needed
                            )
                            Text(
                                text = stringResource(R.string.adminBio)
                            )
                        }

                    }

                }
                item {
                    Card(
                        border = BorderStroke(1.dp, Color.Black),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.skills),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            // Skills section
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                // Skill 1
                                Image(
                                    painter = painterResource(R.drawable.graphic_design_svgrepo_com),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(end = 14.dp)
                                )
                                Text(
                                    text = stringResource(R.string.graphic_design),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                // Skill 2
                                Image(
                                    painter = painterResource(R.drawable.android_svgrepo_com),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(end = 14.dp)
                                )
                                Text(
                                    text = stringResource(R.string.mobile_development),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                            }

                            // Additional skills (if needed)
                            // ...

                        }
                    }
                }
                item {
                    Card(
                        border = BorderStroke(1.dp, Color.Black),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.notes),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            // Display saved notes
                            if (notesListState.isNotEmpty()) {
                                Column {
                                    notesListState.forEach { note ->
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 8.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            // Display note text
                                            Text(
                                                text = note,
                                                modifier = Modifier.weight(1f)
                                            )

                                            // "X" icon to delete the note
                                            if (notesListState.isNotEmpty()) {
                                                IconButton(
                                                    onClick = {
                                                        val updatedList = notesListState.filterNot { it == note }.filter { it.isNotBlank() }.toMutableList()
                                                        notesListState = updatedList
                                                        appPreferences.saveNotes(notesListState)
                                                    },
                                                    modifier = Modifier.size(24.dp)
                                                ) {
                                                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                                                }
                                            }

                                        }
                                    }
                                }
                            }

                            if (isAddingNotes) {
                                // Display the text field when adding notes
                                TextField(
                                    value = addingNotesTextField,
                                    onValueChange = {
                                        addingNotesTextField = it
                                    },
                                    label = { Text(stringResource(R.string.enter_your_note)) },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                )
                            }

                            // "Add notes" button
                            Button(
                                onClick = {
                                    // Toggle the visibility of the text field
                                    isAddingNotes = !isAddingNotes

                                    // If notes are being added and the text is not blank, save them to the list
                                    if (!isAddingNotes && addingNotesTextField.isNotBlank()) {
                                        notesListState = notesListState.toMutableList().apply {
                                            add(addingNotesTextField)
                                        }
                                        appPreferences.saveNotes(notesListState)
                                        addingNotesTextField = ""
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                            ) {
                                Text(
                                    text = if (isAddingNotes) stringResource(R.string.save_note) else stringResource(
                                        R.string.add_note
                                    ),
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}