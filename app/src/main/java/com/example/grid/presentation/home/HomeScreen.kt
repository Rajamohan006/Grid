package com.example.grid.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.data.Job
import com.example.grid.presentation.navigation.BottomNavigationBar
import com.example.grid.presentation.navigation.Screens
import com.example.grid.ui.theme.Surfaceee
import com.example.grid.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val jobs = listOf(
        Job(
            imageResId = R.drawable.logo,
            role = "Lead UI Designer",
            company = "Reapp Technologies Pvt Ltd",
            location = "Chennai, Tamil Nadu",
            time = "Part Time"
        ),
        Job(
            imageResId = R.drawable.logo,
            role = "Software Engineer",
            company = "Tech Solutions",
            location = "Bangalore, Karnataka",
            time = "Full Time"
        ),
        Job(
            imageResId = R.drawable.logo,
            role = "Product Manager",
            company = "Innovative Labs",
            location = "Mumbai, Maharashtra",
            time = "Remote"
        ),
        Job(
            imageResId = R.drawable.logo,
            role = "Data Scientist",
            company = "DataX Inc.",
            location = "Hyderabad, Telangana",
            time = "Full Time"
        ),
        Job(
            imageResId = R.drawable.logo,
            role = "Marketing Specialist",
            company = "Creative Solutions",
            location = "Delhi, India",
            time = "Part Time"
        )
    )
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.background(Surfaceee),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(24.dp)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.grid),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Jobs",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Surfaceee // Correctly set the background color
                ),

            )
        },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = Screens.HomeScreen.route,
                onItemSelected = {route ->
                    navController.navigate(route)
                }
            )
        },
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .background(Surfaceee)
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 44.dp, vertical = 16.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, TextColor.copy(alpha = 0.5f))
                    .background(Color.White)
                    .padding(start = 12.dp)

            ) {
                // Leading Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxSize()
                ) {

                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { newValue -> searchQuery = newValue },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        textStyle = TextStyle(
                            color = TextColor,
                            fontSize = 14.sp
                        ),
                        decorationBox = { innerTextField ->
                            if (searchQuery.isEmpty()) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.searchh),
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp),
                                        tint = TextColor.copy(alpha = 0.5f)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = "Search jobs",
                                        color = TextColor.copy(alpha = 0.5f),
                                        fontSize = 12.sp // Placeholder text size
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.CenterStart // Centers the entered text
                            ) {
                                innerTextField()
                            }
                        }
                    )
                }
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(jobs.size) { index ->
                    Box(
                        modifier = Modifier
                            .border(1.dp, TextColor.copy(0.5f), RoundedCornerShape(12.dp))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = jobs[index].role,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
            Text(
                text = "Jobs Feed",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 24.dp)
            )

            Spacer(modifier = Modifier.height(0.dp))

            // Job feed list
            LazyColumn(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),

            ) {
                items(jobs.size) { index ->
                    val job = jobs[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        colors = CardDefaults.cardColors( 
                            containerColor = Color.White
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp)
                                .background(Color.White),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(job.imageResId),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = job.role,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = job.company,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "${job.location} | ${job.time}",
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}
@Composable
fun JobRow(job: Job) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = job.imageResId), // Use painterResource here
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = job.role,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = job.company,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${job.location} | ${job.time}",
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navController = rememberNavController(),
    )
}
