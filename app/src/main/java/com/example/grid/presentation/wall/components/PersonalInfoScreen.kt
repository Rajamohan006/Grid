package com.example.grid.presentation.wall.components

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.ui.theme.ProfileColor
import com.example.grid.ui.theme.Surfaceee
import java.util.Calendar

@Composable
fun PersonalInfoScreen(navController: NavController) {
    var progress: Float = 40f
    var isPhoneSelected by remember { mutableStateOf(true) }

    var day by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("") }

    val countryList = listOf(
        "India", "USA", "UK", "Canada", "Australia", "Germany", "France", "Japan", "China", "Brazil",
        "Russia", "South Africa", "Mexico", "Italy", "Spain", "South Korea", "New Zealand", "Netherlands", "Argentina", "Sweden"
    )
    val flagList = listOf(
        R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,
        R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,
        R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,
        R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,R.drawable.flag,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Surfaceee)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Surfaceee)
                .height(140.dp)
        ) {
            Text(
                text = "${progress}% Profile completed",
                color = Color.Green,
                modifier = Modifier.align(Alignment.BottomEnd)
                    .padding(4.dp)
            )
        }
        Box(
            modifier = Modifier.padding(start = 35.dp, top = 90.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.avatar_5),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(78.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 190.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Basic Details",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Description about how to fill out details.",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(7.dp))
            ProgressionBar(progress = 70f)
            Spacer(modifier = Modifier.height(7.dp))
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFC7B7FF))
                        .clickable { isPhoneSelected = true },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Basic Details",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))


            Text(text = "Date of Birth", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                DateBox(value = day, label = "Day", onClick = {
                    showDatePicker(context) { selectedDay, selectedMonth, selectedYear ->
                        day = selectedDay
                        month = selectedMonth
                        year = selectedYear
                    }
                })
                DateBox(value = month, label = "Month", onClick = {
                    showDatePicker(context) { selectedDay, selectedMonth, selectedYear ->
                        day = selectedDay
                        month = selectedMonth
                        year = selectedYear
                    }
                })
                DateBox(value = year, label = "Year", onClick = {
                    showDatePicker(context) { selectedDay, selectedMonth, selectedYear ->
                        day = selectedDay
                        month = selectedMonth
                        year = selectedYear
                    }
                }
                )
            }



            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Enter Your Nationality", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded }
                        .shadow(6.dp, RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .clip(RoundedCornerShape(8.dp)),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .height(50.dp)
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Row(
                            modifier =
                            Modifier.padding(start = 8.dp)
                        ) {
                            Icon(
                                painter = painterResource(
                                    id = if (selectedCountry.isNotEmpty()) flagList[countryList.indexOf(
                                        selectedCountry
                                    )] else R.drawable.flag
                                ),
                                contentDescription = "Country Flag",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (selectedCountry.isNotEmpty()) selectedCountry else "Select Country",
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = "Dropdown Arrow",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    countryList.forEachIndexed { index, country ->
                        DropdownMenuItem(
                            onClick = {
                                selectedCountry = country
                                expanded = false
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = flagList[index]),
                                    contentDescription = "Flag"
                                )
                            },
                            text = { Text(text = country) }
                        )
                    }
                }
            }
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateBox(value: String, label: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(90.dp)
            .shadow(6.dp, RoundedCornerShape(8.dp)), // Add shadow for elevation effect
        shape = RoundedCornerShape(8.dp), // Rounded corners
        colors = CardDefaults.cardColors(containerColor = Color.White) // Card background color
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {}, // Do nothing on change since it's read-only
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, color = Color.White)
                .clickable { onClick() }, // Click action to show date picker
            label = { Text(label) },
            singleLine = true,
            readOnly = true,
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.White
            )
        )
    }
}

fun showDatePicker(context: Context, onDateSelected: (String, String, String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            onDateSelected(selectedDay.toString(), (selectedMonth + 1).toString(), selectedYear.toString())
        },
        year,
        month,
        day
    )

    datePickerDialog.show()
}

@Composable
@Preview(showBackground = true)
fun PersonalPreview(){
    val navController = rememberNavController()
    PersonalInfoScreen(navController)
}