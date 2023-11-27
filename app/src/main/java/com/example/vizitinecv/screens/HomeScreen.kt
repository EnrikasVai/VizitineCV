package com.example.vizitinecv.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.LocaleList
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vizitinecv.R
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, activity: ComponentActivity) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.home),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    if (navController.currentBackStackEntry?.destination?.route != "screen1") {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                        }
                    }
                },
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                item {
                    // Display photo
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(shape = CircleShape)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    // Display name and email
                    Text(text = stringResource(R.string.MyName), fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
                    Text(text = stringResource(R.string.MyEmail), color = Color.DarkGray)
                }

                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }

                // View CV and View Portfolio buttons
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                                .size(150.dp)
                                .background(
                                    MaterialTheme.colorScheme.tertiary,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { navController.navigate("screen2") },
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = Color.Black)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = stringResource(R.string.view_cv))
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                                .size(150.dp)
                                .background(
                                    MaterialTheme.colorScheme.tertiary,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { navController.navigate("screen4") },
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_work_24),
                                    contentDescription = "Work Icon",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = stringResource(R.string.portfolio))
                            }
                        }
                    }
                }

                // Contact and QR buttons
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                                .size(150.dp)
                                .background(
                                    MaterialTheme.colorScheme.tertiary,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { navController.navigate("screen3") },
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_email_24),
                                    contentDescription = "Email Icon",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = stringResource(R.string.contact_me))
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                                .size(150.dp)
                                .background(
                                    MaterialTheme.colorScheme.tertiary,
                                    shape = MaterialTheme.shapes.medium
                                )
                                .clickable { navController.navigate("screen5") },
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_qr_code_24),
                                    contentDescription = "QR Icon",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = stringResource(R.string.qr))
                            }
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = stringResource(R.string.select_language) , color = Color.Black, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        LanguageButton(locale = Locale.ENGLISH, context = context, onClick = { restartActivity(activity) }) {
                            Text(text = stringResource(R.string.english))
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        LanguageButton(locale = Locale("lt"), context = context, onClick = { restartActivity(activity) }) {
                            Text(text = stringResource(R.string.lithuanian))
                        }
                    }
                }
            }
        }
    )
}

@SuppressLint("NewApi")
fun setLocale(locale: Locale, context: Context) {
    Locale.setDefault(locale)
    val resources = context.resources
    val configuration = resources.configuration

    // For API 17 and higher, use LocaleList
    val localeList = LocaleList(locale)
    configuration.setLocales(localeList)

    // Update the configuration
    resources.updateConfiguration(configuration, resources.displayMetrics)
}

fun restartActivity(activity: ComponentActivity) {
    val intent = Intent(activity, activity::class.java)
    activity.finish()
    activity.startActivity(intent)
}

@Composable
fun LanguageButton(locale: Locale, context: Context, onClick: () -> Unit, content: @Composable (Modifier) -> Unit) {
    Button(
        onClick = {
            setLocale(locale, context)
            onClick()
        },
        modifier = Modifier
            .height(80.dp)
    ) {
        content(Modifier)
    }
}