package com.example.grid.presentation.auth

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grid.R
import com.example.grid.ui.theme.TextColor
import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.presentation.navigation.Screens
import com.example.grid.ui.theme.Surfaceee
import com.google.accompanist.pager.PagerState
import java.util.Calendar

@Composable
fun PersonalDetailsScreen(navController: NavController) {
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                       Surfaceee,
                        Color.White
                    )
                )
            )
            .padding(16.dp)
    ) {
        HorizontalPager(
            count = 2,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> PersonalDetailsScreen1(navController = navController)
                1 -> PersonalDetailsScreen2(navController = navController)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LinePagerIndicator(
            pagerState = pagerState,
            pageCount = 2,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 8.dp),
            activeColor = MaterialTheme.colorScheme.primary,
            inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
    }
}

@Composable
fun LinePagerIndicator(
    pagerState: PagerState,
    pageCount: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = Color.Black,
    inactiveColor: Color = Color.Gray,
    lineHeight: Float = 4f,
    spacing: Float = 16f
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing.dp)
    ) {
        for (i in 0 until pageCount) {
            val color = if (i == pagerState.currentPage) activeColor else inactiveColor

            Canvas(
                modifier = Modifier
                    .weight(1f)
                    .height(lineHeight.dp)
            ) {
                drawLine(
                    color = color,
                    start = Offset(0f, size.height / 2),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = size.height,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalDetailsScreen1(navController: NavController) {

    var dob by remember { mutableStateOf("") }
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
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Surfaceee)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(Surfaceee)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "Hi",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Swetha",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Enter details",
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Enter Your D.O.B",
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(22.dp))
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(46.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)) // Rounded background
                    .clickable {
                        showDatePicker(context) { date ->
                            dob = date
                        }
                    }
                    .padding(horizontal = 16.dp)
            ) {
                BasicTextField(
                    value = dob,
                    onValueChange = { dob = it },
                    readOnly = true,
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    decorationBox = { innerTextField ->
                        if (dob.isEmpty()) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_calendar_month_24),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "dd/mm/yyyy",
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                        }
                        innerTextField()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Select Your Country",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { expanded = !expanded }
                            .background(MaterialTheme.colorScheme.background)
                            .padding(16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
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
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Confirm",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        navController.navigate(Screens.HomeScreen.route){
                            popUpTo(Screens.OTPScreen.route) {
                                inclusive = true
                            }
                        }
                    })
            }

    }
}

fun showDatePicker(context: Context, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            onDateSelected(selectedDate)
        },
        year,
        month,
        day
    )

    datePickerDialog.show()
}
@Composable
fun PersonalDetailsScreen2(
    navController: NavController
) {
    var expandedRole by remember { mutableStateOf(false) }
    var selectedRole by remember { mutableStateOf("Select Role") }

    var expandedExperience by remember { mutableStateOf(false) }
    var selectedExperience by remember { mutableStateOf("Select Experience") }

    var expandedLocation by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf("Select Location") }

    val jobRoles = listOf(
        "Software Engineer", "Data Scientist", "Product Manager", "UI/UX Designer", "Mobile Developer",
        "Backend Developer", "DevOps Engineer", "AI Engineer", "Security Analyst", "System Administrator",
        "IT Consultant", "Project Manager", "Quality Assurance", "Cloud Engineer", "Full Stack Developer",
        "Frontend Developer", "Database Administrator", "Network Engineer", "Technical Writer", "Support Engineer"
    )

    val experienceLevels = listOf("Fresher", "1-2 Years", "3-5 Years", "5-7 Years", "7+ Years")

    val locations = listOf("Delhi", "Mumbai", "Bangalore", "Hyderabad", "Chennai", "Pune", "Kolkata", "Ahmedabad")

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surface,
                        Color.White
                    )
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Surfaceee,
                            Color.White
                        )
                    )
                )
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(16.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }

            Spacer(modifier = Modifier.height(27.dp))
            Text(
                text = "Job preference",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Select Your Role",
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { expandedRole = !expandedRole }
                    .background(Color.White, shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = selectedRole)
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expandedRole,
                    onDismissRequest = { expandedRole = false }
                ) {
                    jobRoles.forEach { role ->
                        DropdownMenuItem(onClick = {
                            selectedRole = role
                            expandedRole = false
                        },
                            text = { Text(text = role) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Experience",
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { expandedExperience = !expandedExperience }
                    .background(Color.White, shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = selectedExperience)
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expandedExperience,
                    onDismissRequest = { expandedExperience = false }
                ) {
                    experienceLevels.forEach { experience ->
                        DropdownMenuItem(onClick = {
                            selectedExperience = experience
                            expandedExperience = false
                        },
                            text = { Text(text = experience) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Preferred Location",
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { expandedLocation = !expandedLocation }
                    .background(Color.White, shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = selectedLocation)
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expandedLocation,
                    onDismissRequest = { expandedLocation = false }
                ) {
                    locations.forEach { location ->
                        DropdownMenuItem(onClick = {
                            selectedLocation = location
                            expandedLocation = false
                        },
                            text = { Text(text = location) })
                    }
                }
            }
        }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Confirm",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        navController.navigate(Screens.HomeScreen.route){
                            popUpTo(Screens.OTPScreen.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

    }
}
@Preview(showBackground = true)
@Composable
fun PersonalDetailsPreview(){
    val navController = rememberNavController()
    PersonalDetailsScreen(navController = navController)
}
@Preview(showBackground = true)
@Composable
fun PersonalDetails2(){
    val navController = rememberNavController()
    PersonalDetailsScreen2(navController = navController)
}