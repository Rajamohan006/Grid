package com.example.grid.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.presentation.navigation.Screens
import com.example.grid.ui.theme.Surfaceee
import com.example.grid.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ApplyScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current
    val skills = listOf("UX", "UI Design", "Figma"," Adobe Xd" , "Photoshop", "Illustrator","User Personal","Information Architecture","User interview" )
    val listState = rememberLazyListState()
    var showButton by remember { mutableStateOf(true) } // Button visibility state

    showButton = listState.firstVisibleItemIndex == 0
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Gray.copy(0.5f)
                        )
                    }
                },
                title = {
                    Box(Modifier.fillMaxWidth()) {

                    }
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.bookmark_outline),
                            contentDescription = "Bookmark",
                            modifier = Modifier.size(24.dp)
                                .clickable {  }
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Icon(
                            painter = painterResource(R.drawable.share_socialoutline),
                            contentDescription = "share",
                            modifier = Modifier.size(24.dp)
                                .clickable {  }
                        )
                    }
                },
                modifier = Modifier  .padding(top = 21.dp , start =16.dp, end = 16.dp)
                    .background(
                        Surfaceee
                    )
            )
        },
        modifier = Modifier.background(Surfaceee)
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()
            .background(Surfaceee)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .background(Surfaceee)

            ) {
                Card(//company details
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)

                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Column {
                                Text(
                                    text = "UI/UX Designer",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Reapp Technologies Pvt Its",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "Chennai, TamilNadu-Full Time",
                                    fontSize = 14.sp,
                                    color = Color.Gray

                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                painter = painterResource(R.drawable.logo),
                                contentDescription = "logo",
                                modifier = Modifier.size(40.dp)
                                    .align(Alignment.Top)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.onsite),
                                    contentDescription = "onsite",
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "100 Employees",
                                    fontSize = 12.sp,
                                    color = Color.Gray

                                )
                            }
                            Spacer(modifier = Modifier.height(9.dp))
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.height(9.dp))
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.usersthree),
                                        contentDescription = "employees",
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "100 Employees",
                                        fontSize = 12.sp,
                                        color = Color.Gray

                                    )
                                }

                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.userslist),
                                    contentDescription = "usersList",
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "6 skills",
                                    fontSize = 12.sp,
                                    color = Color(0xFF4CAF50)

                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "matches your profile -Out of 10",
                                    fontSize = 12.sp,
                                    color = Color.Gray

                                )

                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(1.dp))
                Card(//skills
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.background(Color.White)
                    ) {
                        Text(
                            text = "Skills",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val rowSpacing = 8.dp
                                val itemSpacing = 8.dp
                                var currentRowItems = mutableListOf<String>()
                                var currentRowWidth = 0.dp

                                skills.forEach { skill ->
                                    val skillWidth = (skill.length * 10).dp

                                    if (currentRowWidth + skillWidth + itemSpacing > LocalConfiguration.current.screenWidthDp.dp) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.spacedBy(itemSpacing)
                                        ) {
                                            currentRowItems.forEach { rowSkill ->
                                                SkillBox(rowSkill)
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(rowSpacing))
                                        currentRowWidth = 0.dp
                                        currentRowItems = mutableListOf()
                                    }
                                    currentRowItems.add(skill)
                                    currentRowWidth += skillWidth + itemSpacing // Include spacing in the width
                                }

                                if (currentRowItems.isNotEmpty()) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(), // Ensure the last row also fills the width
                                        horizontalArrangement = Arrangement.spacedBy(itemSpacing)
                                    ) {
                                        currentRowItems.forEach { rowSkill ->
                                            SkillBox(rowSkill) // Display the remaining skills
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Web app design",
                                    fontSize = 12.sp,
                                    color = Color.Gray,
                                    modifier = Modifier.align(Alignment.BottomStart)
                                )
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.background(Color.White)
                                .fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier.size(54.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.img),
                                    contentDescription = "profile",
                                    modifier = Modifier.align(Alignment.Center)
                                        .fillMaxSize()
                                )
                            }
                            Row(
                                modifier = Modifier.background(Color.White)
                                    .fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.background(Color.White)
                                        .fillMaxWidth()
                                        .padding(start = 16.dp)
                                ) {
                                    Text(
                                        text = "Karan",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Human Resource Management",
                                        fontSize = 12.sp,
                                        color = Color.Gray
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Row(
                                        modifier = Modifier.align(Alignment.Start)
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.usercirclecheck),
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "locked",
                                            fontSize = 10.sp,
                                            color = Color(0xFFEE2F23)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "your skills not matched",
                                            fontSize = 10.sp,
                                            color = Color.Gray
                                        )
                                    }

                                }
                                Column(
                                    horizontalAlignment = Alignment.End,
                                    verticalArrangement = Arrangement.Top
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.chat),
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                            .align(Alignment.CenterHorizontally),
                                        tint = Color.Gray
                                    )
                                    Text(
                                        text = "Reach",
                                        fontSize = 10.sp,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(1.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth()
                            .padding(16.dp)
                            .background(Color.White)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Job details",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Column(
                            ) {
                                Row() {
                                    Text(
                                        text = "Salary",
                                        fontSize = 12.sp,
                                        color = Color.Black.copy(0.7f),
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.width(80.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "400000 - 600000 a year",
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Row() {
                                    Text(
                                        text = "Experience",
                                        fontSize = 12.sp,
                                        color = Color.Black.copy(0.7f),
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.width(80.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "4-6 years",
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Row() {
                                    Text(
                                        text = "Education",
                                        fontSize = 12.sp,
                                        color = Color.Black.copy(0.7f),
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.width(80.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "Bachelors",
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }

                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "We is seeking a talented and experienced UX/UI Designer to join our dynamic team. As a UX/UI Designer, you will be responsible for creating intuitive and visually appealing user interfaces for our digital products. You will work closely with cross-functional teams to understand user needs, conduct research, and translate findings into innovative design solutions. This role requires a passion for user-centered design, excellent communication skills, and a strong portfolio showcasing your design expertise.",
                                fontSize = 12.sp,
                                color = Color.Gray,
                                lineHeight = 20.sp
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Responsibilities:",
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            BulletPointText(text = "Collaborate with product managers, developers, and other stakeholders to define user requirements and design goals.")
                            Spacer(modifier = Modifier.height(4.dp))

                            BulletPointText(text = "Conduct user research, including usability testing, surveys, and interviews, to gather insights and validate design decisions.")
                            Spacer(modifier = Modifier.height(4.dp))

                            BulletPointText(text = "Create wireframes, prototypes, and high-fidelity mockups to illustrate design concepts and interactions.")
                            Spacer(modifier = Modifier.height(4.dp))

                            BulletPointText(text = "Iterate on designs based on feedback, user testing, and data analysis to continuously improve the user experience.")
                            Spacer(modifier = Modifier.height(4.dp))

                            BulletPointText(text = "Ensure designs adhere to brand guidelines and accessibility standards.")
                            Spacer(modifier = Modifier.height(4.dp))

                            BulletPointText(text = "Stay updated on industry trends and best practices in UX/UI design.")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(1.dp))
                Card(//company
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Company details",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Confidential info 200-499 Employee. IT",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Company Founded 2015 - 01",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Official Website",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        ClickableText(
                            text = AnnotatedString(
                                text = "https://developer.android.com/?authuser=1",
                                spanStyle = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 12.sp,
                                    textDecoration = TextDecoration.Underline,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ),
                            onClick = {
                                uriHandler.openUri("https://developer.android.com/?authuser=1")
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "View all",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.clickable { navController.navigate(Screens.CompanyDetailsScreen.route) })
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "More jobs",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(14.dp))
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Lead Ui Designer",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Reapp Technologies Pvt Its",
                                fontSize = 14.sp,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Channai, TamilNadu - Part Time")
                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Lead Ui Designer",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Reapp Technologies Pvt Its",
                                fontSize = 14.sp,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Channai, TamilNadu - Part Time")
                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Lead Ui Designer",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Reapp Technologies Pvt Its",
                                fontSize = 14.sp,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Channai, TamilNadu - Part Time")
                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Lead Ui Designer",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Reapp Technologies Pvt Its",
                                fontSize = 14.sp,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Channai, TamilNadu - Part Time")
                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Lead Ui Designer",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Reapp Technologies Pvt Its",
                                fontSize = 14.sp,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Channai, TamilNadu - Part Time")
                        }
                    }

                }
                Spacer(modifier = Modifier.height(8.dp))


            }
            if (showButton) {
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Text(text="Apply",
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }

}
@Composable
fun BulletPointText(text: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "•",
            modifier = Modifier.padding(end = 8.dp),
            fontSize = 14.sp,
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 12.sp,
            color = Color.Gray,
            lineHeight = 20.sp
        )
    }
}
@Composable
fun SkillBox(skill: String) {
    Box(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = skill,
            fontSize = 12.sp,
            color = Color(0xFF4CAF50)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ApplyScreenPreview(){
    val navController = rememberNavController()
    ApplyScreen(navController)
}