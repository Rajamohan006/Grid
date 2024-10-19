package com.example.grid.data

import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.grid.R

data class Job(
    val imageResId: Int, 
    val role: String,
    val company: String,
    val location: String,
    val time: String
)

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
