package com.example.grid.presentation.home

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.ui.theme.Surfaceee

@Composable
fun FilterScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .width(220.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.align(Alignment.Center)
                        .width(220.dp)

                ) {
                    Text(
                        text = "Search jobs",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.padding(16.dp)
                    .background(Surfaceee)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(top = 30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                            .offset(x = (-10).dp)
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
                Row {

                    Text(
                        text = "Find job",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "back",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                            .clickable {  }


                    )
                }
                Spacer(modifier = Modifier.height(38.dp))

                // Dropdown Menu Fields
                DropdownMenuField(label = "Designation", items = listOf("Developer", "Manager", "Designer"), label2 = "Choose your designation")
                DropdownMenuField(label = "Experience", items = listOf("1-2 years", "3-5 years", "5+ years"), label2 = "Choose your experience")
                DropdownMenuField(label = "Job type", items = listOf("Full-time", "Part-time", "Internship"), label2 = "Choose your job type")
                DropdownMenuField(label = "Companies", items = listOf("Company A", "Company B", "Company C"), label2 = "Choose your company")
                DropdownMenuField(label = "Preferred city", items = listOf("New York", "San Francisco", "Los Angeles"), label2 = "Choose your city")
                DropdownMenuField(label = "Salary", items = listOf("$50,000", "$60,000", "$70,000"), label2 = "Mention salary")

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun DropdownMenuField(
    label: String,
    items: List<String>,
    label2: String
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }  // Empty initially to indicate no selection

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clickable { expanded = true }
                .background(Color.White),
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Text(
                    text = if (selectedItem.isEmpty()) label2 else selectedItem,  // Show label2 if nothing is selected
                    fontSize = 13.sp,
                    color = if (selectedItem.isEmpty()) Color.Gray else Color.Black,  // Placeholder color if empty
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem = item
                        expanded = false
                    },
                    text = { Text(text = item) }
                )
            }
        }

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview(){
    val navController= rememberNavController()
    FilterScreen(navController = navController)
}