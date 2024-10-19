package com.example.grid.presentation.wall

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.ui.theme.Surfaceee
import com.example.grid.ui.theme.TextColor
import com.example.grid.ui.theme.TextColors

@Composable
fun WallFullScreen(navController: NavController) {
    var text: String=
            "As a UX/UI designer, I am passionate about crafting digital experiences that seamlessly blend functionality with aesthetics. With a keen eye for detail and a deep understanding Wireframes and prototypes are my playground, where I sculpt the structure and flow of the user journey "
    val  maxLines: Int = 5
    val expanded = remember { mutableStateOf(false) }
    val textLayoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.background(Surfaceee)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(start = 55.dp, top = 38.dp, end = 55.dp)
                            .background(Color.White)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(94.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray), // Optional background
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.img),
                                contentDescription = null,
                                modifier = Modifier.size(94.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(color = Color(0xFF895200))
                                    .align(Alignment.TopEnd)
                                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.verify),
                                    contentDescription = "Active Status",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                        ) {
                            Text(
                                text = "Swetha",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,

                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "UXUi Designer",
                                fontSize = 14.sp,
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Verified",
                                fontSize = 10.sp,
                                color = Color(0xFFFFC718)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "About",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(modifier = Modifier.padding(vertical = 8.dp)) {
                        Text(
                            text = if (expanded.value) text else getTruncatedText(text, maxLines, textLayoutResult.value),
                            fontSize = 13.sp,
                            lineHeight = 21.sp,
                            color = Color.Gray,
                            onTextLayout = { textLayoutResult.value = it },
                            modifier = Modifier.clickable { expanded.value = !expanded.value }
                        )

                        if (!expanded.value && textLayoutResult.value?.lineCount ?: 0 > maxLines) {
                            Text(
                                text = "Know More",
                                fontSize = 13.sp,
                                color = Color.Blue,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expanded.value = true }
                                    .padding(top = 4.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(text = "Location",
                                fontSize =16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black.copy(0.5f)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "Chennai",
                                fontSize =14.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(text = "Education",
                                fontSize =16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black.copy(0.5f)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "BE, MBA",
                                fontSize =14.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(text = "Experience",
                                fontSize =16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black.copy(0.5f)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = "1 year, 2 months",
                                fontSize =14.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(34.dp))
                    Box(modifier = Modifier.width(260.dp)
                        .height(46.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .align(Alignment.CenterHorizontally),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "Download your Profile",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Contact",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier.size(24.dp)
                                .background(Color.White)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.pen_pen),
                                contentDescription = "pen",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Text(text = "Email Address",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray.copy(0.5f)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Column {
                            Text(text = "swesswf46@gmail.com",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.align(Alignment.End)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Registered",
                                fontSize = 14.sp,
                                color = Color.Green,
                                modifier = Modifier.align(Alignment.End)
                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Text(text = "Mobile Number",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray.copy(0.5f)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Column {
                            Text(text = "+91 6466743245",
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.align(Alignment.End)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Registered",
                                fontSize = 14.sp,
                                color = Color.Green,
                                modifier = Modifier.align(Alignment.End)
                            )

                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Education",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier.size(24.dp)
                                .background(Color.White)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_add_24),
                                contentDescription = "add",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    ) {
                        EducationText(
                            degree = "Masters degree",
                            role = "human resource",
                            university = "Anna university",
                            location = "Chennai",
                            duration = " September 2017- August 2021"
                        )

                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    ) {
                        EducationText(
                            degree ="BE" ,
                            role = "Computer ",
                            university = "Anna university",
                            location = "Chennai",
                            duration = " September 2017- August 2021"
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Primary Skills",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier.size(24.dp)
                                .background(Color.White)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.pen_pen),
                                contentDescription = "pen",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    val skills = listOf(
                        Skill("Figma", SkillLevel.EXPERT),
                        Skill("Adobe xd", SkillLevel.INTERMEDIATE),
                        Skill("Photoshop", SkillLevel.BEGINNER),
                        Skill("Illustator", SkillLevel.EXPERT),
                        Skill("Wix", SkillLevel.EXPERT),
                        Skill("adobe creative", SkillLevel.EXPERT),
                        )

                    SkillRow(skills)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.export),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .background(Color.White)
                        ) {
                            Box(
                                modifier = Modifier.size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Green)
                            ) {
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Expert",
                                fontSize = 10.sp,
                                color = TextColor
                                )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .background(Color.White)
                        ) {
                            Box(
                                modifier = Modifier.size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Yellow)
                            ) {
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Intermediate",
                                fontSize = 10.sp,
                                color = TextColor
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .background(Color.White)
                        ) {
                            Box(
                                modifier = Modifier.size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Red)
                            ) {
                            }
                            Spacer(modifier = Modifier.width(4.dp))

                            Text(text = "Beginner",
                                fontSize = 10.sp,
                                color = TextColor
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Secondary Skills",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier.size(24.dp)
                                .background(Color.White)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_add_24),
                                contentDescription = "pen",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    val skills = listOf(
                        Skill("Figma", SkillLevel.EXPERT),
                        Skill("Adobe xd", SkillLevel.INTERMEDIATE),
                        Skill("Photoshop", SkillLevel.BEGINNER),
                        Skill("Illustator", SkillLevel.EXPERT),
                        Skill("Wix", SkillLevel.EXPERT),
                        Skill("adobe creative", SkillLevel.EXPERT),
                    )

                    SkillRow(skills)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.export),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .background(Color.White)
                        ) {
                            Box(
                                modifier = Modifier.size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Green)
                            ) {
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Expert",
                                fontSize = 10.sp,
                                color = TextColor
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .background(Color.White)
                        ) {
                            Box(
                                modifier = Modifier.size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Yellow)
                            ) {
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Intermediate",
                                fontSize = 10.sp,
                                color = TextColor
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .background(Color.White)
                        ) {
                            Box(
                                modifier = Modifier.size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Red)
                            ) {
                            }
                            Spacer(modifier = Modifier.width(4.dp))

                            Text(text = "Beginner",
                                fontSize = 10.sp,
                                color = TextColor
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Experience",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "1 year 2 months",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text( text = "UXUI designer at infosys",
                                fontSize = 14.sp,
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier.size(24.dp)
                                    .background(Color.White)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.pen_pen),
                                    contentDescription = "pen",
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "july 2023-Present" ,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "India-Chennai",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "My journey in design began with a fascination for understanding human behavior and translating those insights into intuitive interfaces. Through extensive research and empathy-driven methodologies, I delve into the minds of users to uncover their needs, motivations, and pain points.",
                            fontSize = 13.sp,
                            color = TextColor,
                            lineHeight = 21.sp,
                            )
                        Spacer(modifier = Modifier.height(32.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Text(text = "Project details",
                                fontSize = 14.sp,
                                )
                            Spacer(modifier = Modifier.height(24.dp))
                            ProjectDetails(
                                text ="BlueSky Technologies",
                                duration = "January 2023- March 2023",
                                role = "Figma, Adobe XD,Sketch, InVision, UserTesting",
                                projectName = "SkyConnect - A Next-Gen Social Networking Platform"
                            )
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                        ProjectExplanation(
                            project = "Project Explanation",
                            description = "SkyConnect aimed to revolutionize the social networking landscape by prioritizing user privacy, mental well-being, and meaningful connections. The platform offered unique features such as AI-driven content moderation, customizable privacy settings, and curated interest."
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        ProjectExplanation(
                            project = "Major Problem Solved",
                            description ="The major challenge was to design a platform that fosters genuine interactions while ensuring user safety and privacy. Implementing robust content moderation algorithms and intuitive privacy controls helped mitigate concerns over online harassment and data breaches."
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = "Contribution",
                            fontSize = 15.sp,
                            )
                        Spacer(modifier = Modifier.height(24.dp))
                        Row (
                            modifier = Modifier.fillMaxWidth()
                                .background(Color.White)
                        ){
                            Box(
                                modifier = Modifier.padding()
                                    .clip(RoundedCornerShape(15.dp))
                                    .align(Alignment.CenterVertically)
                                .background(Color.Gray.copy(0.3f))

                            ) {
                                Text(text = "Support",
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(start =  8.dp, end = 8.dp, top = 6.dp, bottom = 6.dp))
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier.padding()
                                    .clip(RoundedCornerShape(15.dp))
                                    .align(Alignment.CenterVertically)
                                    .background(Color.Gray.copy(0.3f))

                            ) {
                                Text(text = "Scratch development",
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(start =  8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp))
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier.padding()
                                    .clip(RoundedCornerShape(15.dp))
                                    .align(Alignment.CenterVertically)
                                    .background(Color.Gray.copy(0.3f))

                            ) {
                                Text(text = "Implementation",
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(start =  8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp))
                            }

                        }
                        Spacer(modifier = Modifier.height(24.dp))
                        Row(
                            modifier = Modifier.background(Color.White)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Project Link:",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            val annotatedText = buildAnnotatedString {
                                pushStyle(
                                    SpanStyle(
                                        color = MaterialTheme.colorScheme.primary,
                                        textDecoration = TextDecoration.Underline // Underline style
                                    )
                                )
                                append("SkyConnect (Placeholder link for demonstration purposes)")
                                addStringAnnotation(
                                    tag = "URL", // Identifier for the annotation
                                    annotation = "project_screen_route", // Route to navigate to
                                    start = 0,
                                    end = this.length
                                )
                                pop()
                            }

                            ClickableText(
                                text = annotatedText,
                                onClick = { offset ->
                                    // Navigate only if the click matches the "URL" annotation
                                    annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                                        .firstOrNull()?.let {
                                            navController.navigate(it.item) // Navigate to the destination screen
                                        }
                                },
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.sp)
                            )
                        }


                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(//language
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Language",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier.size(24.dp)
                                .background(Color.White)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_add_24),
                                contentDescription = "add",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Language(
                        language = "English",
                        level = "Intermediate"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Language(
                        language = "Tamil",
                        level = "Intermediate"
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(// Certification
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Certifications",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier.size(24.dp)
                                .background(Color.White)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_add_24),
                                contentDescription = "add",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Certification(
                        language = "UXUI design course in buff institute",
                        level = "Sep 2023 - 2023"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Certification(
                        language = "UXUI design Work shop",
                        level = "Sep 2023"
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(//link
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.hashtag_circle),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Social profile",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier.size(24.dp)
                                .background(Color.White)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_add_24),
                                contentDescription = "add",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Certification(
                        language = "Behance",
                        level = "http//:asddqjqowjd8e.com"
                    )

                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

    }
}

@Composable
private fun Certification(
    language:String,
    level:String
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.background(Color.White)
                .fillMaxWidth()
        ) {
            Text(text = language,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(painter = painterResource(R.drawable.pen_pen),
                contentDescription = "pen",
                modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = level,
            fontSize = 12.sp,
            color = TextColors
        )

    }

}
@Composable
private fun Language(
    language:String,
    level:String
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.background(Color.White)
                .fillMaxWidth()
        ) {
            Text(text = language,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(painter = painterResource(R.drawable.pen_pen),
                contentDescription = "pen",
                modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Level: $level",
            fontSize = 12.sp,
            color = TextColors
        )

    }

}
@Composable
private fun ProjectExplanation(
    project:String,
    description: String
){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
    ) {
        Text(text = project,
            fontSize = 15.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = description,
            fontSize = 13.sp,
            color = TextColors)
    }

}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectDetails(text: String,
                   duration: String,
                   role: String,
                   projectName: String
){
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                text = "Client",
                fontSize = 12.sp,
                color = Color.Black.copy(0.8f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(Color.White)
            ) {
                Text(
                    text = text,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Divider(modifier = Modifier.height(1.dp)
            .background(TextColor.copy(0.5f)))
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                text = "Time line",
                fontSize = 12.sp,
                color = Color.Black.copy(0.8f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(Color.White)
            ) {
                Text(
                    text = duration,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Divider(modifier = Modifier.height(1.dp)
            .background(TextColor.copy(0.5f)))
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                text = "Tools Used",
                fontSize = 12.sp,
                color = Color.Black.copy(0.8f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(Color.White)
            ) {
                FlowRow(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.background(Color.White)
                ) {
                    Text(
                        text = role,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        Divider(modifier = Modifier.height(1.dp)
            .background(TextColor.copy(0.5f)))
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                text = "Project Name",
                fontSize = 12.sp,
                color = Color.Black.copy(0.8f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.background(Color.White)
            ) {
                FlowRow(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.background(Color.White)
                ) {
                    Text(
                        text = projectName,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        Divider(modifier = Modifier.height(1.dp)
            .background(TextColor.copy(0.5f)))
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillRow(skills: List<Skill>) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
    ) {
        FlowRow {
            skills.forEach { skill ->
                SkillBox(skill)
            }
        }
    }
}

@Composable
fun SkillBox(skill: Skill) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray.copy(0.1f))
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.Center)
                .padding(start = 12.dp, end = 12.dp)
        ) {

            when (skill.level) {
                SkillLevel.EXPERT -> Box(
                    modifier = Modifier.size(8.dp)
                        .clip(CircleShape)
                        .background(Color.Green)
                ) {
                }
                SkillLevel.INTERMEDIATE -> Box(
                    modifier = Modifier.size(8.dp)
                        .clip(CircleShape)
                        .background(Color.Yellow)
                ) {
                }
                SkillLevel.BEGINNER -> Box(
                    modifier = Modifier.size(8.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                ) {
                }
            }
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = skill.name,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
            )
        }
    }
}

data class Skill(val name: String, val level: SkillLevel)

enum class SkillLevel {
    EXPERT, INTERMEDIATE, BEGINNER
}


@Composable
fun EducationText(
    degree: String,
    role: String,
    university: String,
    location: String,
    duration: String
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
        ) {
            Text( text = "$degree , $role",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.size(24.dp)
                    .background(Color.White)
            ) {
                Icon(
                    painter = painterResource(R.drawable.pen_pen),
                    contentDescription = "pen",
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "at $university" ,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = location ,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = duration ,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}
fun getTruncatedText(
    text: String,
    maxLines: Int,
    layoutResult: TextLayoutResult?
): String {
    layoutResult?.let { result ->
        if (result.lineCount > maxLines) {
            val endIndex = result.getLineEnd(maxLines - 1, visibleEnd = true) - 7 // Reserve space for "..."
            return text.substring(0, endIndex).trimEnd() + "..."
        }
    }
    return text
}
@Preview(showBackground = true)
@Composable
fun WallFullScreenPreview(){
    val navController = rememberNavController()
    WallFullScreen(navController = navController)
}