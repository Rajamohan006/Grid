package com.example.grid.presentation.wall.components

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.ui.theme.Greens
import com.example.grid.ui.theme.Surfaceee
import com.example.grid.ui.theme.TextColor

@Composable
fun EducationScreen(navController: NavController) {
    var progress: Int = 40
    var universityName by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var specialization by remember { mutableStateOf("") }
    var courseDuration by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var marks by remember { mutableStateOf("") }
    var courseType by remember { mutableStateOf("") }
    var isAddMore by remember { mutableStateOf(false) }
    var selectedEducationType by remember { mutableStateOf("Graduate") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Surfaceee)
                .height(140.dp)
        ) {
            Text(
                text = "${progress}% Profile completed",
                color = Greens,
                modifier = Modifier.align(Alignment.BottomEnd).padding(4.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 200.dp, end = 16.dp, bottom = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Education",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Here Needed description about the paragraph how to fill and tips get shortlist easily for 2 - 3 lines.",
                fontSize = 12.sp,
                color = TextColor
            )
            Spacer(modifier = Modifier.height(12.dp))
            ProgressionBar(progress = 80f)
            Spacer(modifier = Modifier.height(30.dp))


            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                EducationTypeBox("Graduate", selectedEducationType == "Graduate") {
                    selectedEducationType = "Graduate"
                }
                Spacer(modifier = Modifier.width(16.dp))
                EducationTypeBox("Post Graduate", selectedEducationType == "Post Graduate") {
                    selectedEducationType = "Post Graduate"
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        isAddMore = !isAddMore
                    },
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }


            when (selectedEducationType) {
                "Graduate", "Post Graduate" -> {
                    EducationDetailsForm(
                        universityName, course, specialization, courseDuration, grade, marks, courseType,
                        onUniversityChange = { universityName = it },
                        onCourseChange = { course = it },
                        onSpecializationChange = { specialization = it },
                        onDurationChange = { courseDuration = it },
                        onGradeChange = { grade = it },
                        onMarksChange = { marks = it },
                        onCourseTypeChange = { courseType = it }
                    )
                }
            }


            if (isAddMore) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(text = "Add More", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    EducationTypeBox("Class 10th", selectedEducationType == "Class 10th") {
                        selectedEducationType = "Class 10th"
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    EducationTypeBox("Class 12th", selectedEducationType == "Class 12th") {
                        selectedEducationType = "Class 12th"
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    EducationTypeBox("Doctorate", selectedEducationType == "Doctorate") {
                        selectedEducationType = "Doctorate"
                    }
                }


                when (selectedEducationType) {
                    "Class 10th", "Class 12th", "Doctorate" -> {
                        EducationDetailsForm(
                            universityName, course, specialization, courseDuration, grade, marks, courseType,
                            onUniversityChange = { universityName = it },
                            onCourseChange = { course = it },
                            onSpecializationChange = { specialization = it },
                            onDurationChange = { courseDuration = it },
                            onGradeChange = { grade = it },
                            onMarksChange = { marks = it },
                            onCourseTypeChange = { courseType = it }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun EducationTypeBox(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(30.dp)
            .clip(CircleShape)
            .background(color = if (isSelected) Color(0xFFC7B7FF) else Color.Gray)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )
    }
}


@Composable
fun EducationDetailsForm(
    universityName: String,
    course: String,
    specialization: String,
    courseDuration: String,
    grade: String,
    marks: String,
    courseType: String,
    onUniversityChange: (String) -> Unit,
    onCourseChange: (String) -> Unit,
    onSpecializationChange: (String) -> Unit,
    onDurationChange: (String) -> Unit,
    onGradeChange: (String) -> Unit,
    onMarksChange: (String) -> Unit,
    onCourseTypeChange: (String) -> Unit
) {
    EducationalDetailsField(
        label = "University / Institute name",
        value = universityName,
        onValueChange = onUniversityChange
    )
    Spacer(modifier = Modifier.height(24.dp))
    EducationalDetailsField(
        label = "Course",
        value = course,
        onValueChange = onCourseChange
    )
    Spacer(modifier = Modifier.height(24.dp))
    EducationalDetailsField(
        label = "Specialization",
        value = specialization,
        onValueChange = onSpecializationChange
    )
    Spacer(modifier = Modifier.height(24.dp))
    EducationalDetailsField(
        label = "Course Duration",
        value = courseDuration,
        onValueChange = onDurationChange
    )
    Spacer(modifier = Modifier.height(24.dp))
    EducationalDetailsField(
        label = "Grade",
        value = grade,
        onValueChange = onGradeChange
    )
    Spacer(modifier = Modifier.height(24.dp))
    EducationalDetailsField(
        label = "Mark",
        value = marks,
        onValueChange = onMarksChange
    )
    Spacer(modifier = Modifier.height(24.dp))
    EducationalDetailsField(
        label = "Course type",
        value = courseType,
        onValueChange = onCourseTypeChange
    )
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun EducationalDetailsField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Text(text = label, fontSize = 14.sp)
    Spacer(modifier = Modifier.height(4.dp))
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(28.dp)
    )
}

@Preview(showBackground =  true)
@Composable
fun EducationPreview(){
    val navController = rememberNavController()
    EducationScreen(navController = navController)
}