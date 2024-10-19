package com.example.grid.presentation.wall

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.presentation.navigation.BottomNavigationBar
import com.example.grid.presentation.navigation.Screens
import com.example.grid.ui.theme.DarkBlue
import com.example.grid.ui.theme.ProfileColor
import com.example.grid.ui.theme.Surfaceee

@Composable
fun WallScreen(navController: NavController) {
    val imageRes: Painter = painterResource(id = R.drawable.avatar_5)
    val progress: Float = 0.4f
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = Screens.WallScreen.route,
                onItemSelected = {route ->
                    navController.navigate(route)
                }
            )
        }
    ) {paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues)
                .background(Surfaceee)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = imageRes,
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Canvas(modifier = Modifier.size(170.dp)) {
                    val strokeWidth = 6.dp.toPx()
                    val angle = 360 * progress
                    val radius = size.minDimension / 2
                    drawArc(
                        color = Color.Green,
                        startAngle = 180f,
                        sweepAngle = angle,
                        useCenter = false,
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                        size = Size(size.width, size.height),
                        topLeft = Offset(0f, 0f)
                    )


                    val textAngle = Math.toRadians((180 + angle).toDouble())
                    val textRadius = radius + 30f
                    val textX = textRadius + textRadius * Math.cos(textAngle).toFloat()
                    val textY = textRadius + textRadius * Math.sin(textAngle).toFloat()
                    drawContext.canvas.nativeCanvas.drawText(
                        "${(progress * 100).toInt()}%",
                        textX,
                        textY,
                        android.graphics.Paint().apply {
                            color = Color.Green.toArgb()
                            textAlign = android.graphics.Paint.Align.CENTER
                            textSize = 30f
                            isAntiAlias = true
                        }
                    )
                }

            }
            Spacer(modifier = Modifier.height(13.dp))

            Text(
                text = "Swetha",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "UX/UI Designer",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "2 years Experience",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(70.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.about_you),
                info = "About you",
                progress = 80f,
                onClick = { navController.navigate(Screens.AboutScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.contact),
                info = "Contact",
                progress = 80f,
                onClick = { navController.navigate(Screens.ContactScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.cover_etter),
                info = "Personal Details",
                progress = 80f,
                onClick = { navController.navigate(Screens.PersonalInfoScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.gradu),
                info = "Education",
                progress = 80f,
                onClick = { navController.navigate(Screens.SkillsScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.skillss),
                info = "Skills",
                progress = 80f,
                onClick = { navController.navigate(Screens.SkillsScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.translator),
                info = "Language",
                progress = 80f,
                onClick = { navController.navigate(Screens.LanguageScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.education),
                info = "Cover letter",
                progress = 80f,
                onClick = { navController.navigate(Screens.CoverLetterScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.property),
                info = "Certification",
                progress = 80f,
                onClick = { navController.navigate(Screens.CertificationScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProgressInfo(
                icon = painterResource(R.drawable.link),
                info = "Social profile",
                progress = 80f,
                onClick = { navController.navigate(Screens.SocialProfileScreen.route)}
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressInfo(
    icon: Painter,
    info: String,
    progress: Float,
    onClick: () ->Unit ={}
) {
    Card(
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
            .clickable { onClick }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(DarkBlue)
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.CenterVertically),
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = info,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(R.drawable.eye),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp),
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Few more details to complete, Hurry up",
                    color = Color.LightGray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Slider(
                    value = progress,
                    onValueChange = { newValue ->
                        progress
                    },
                    valueRange = 0f..100f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .align(Alignment.Start)
                        .height(60.dp),
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.primary,
                        activeTrackColor = MaterialTheme.colorScheme.primary,
                        inactiveTrackColor = Color.White
                    ),
                    thumb = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier .offset(y =(6).dp)
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(22.dp)
                                    .clip(CircleShape)
                                    .background(Color.Green),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Thumb Check",
                                    modifier = Modifier.size(16.dp)
                                        .border(1.dp, color = Color.White, shape = CircleShape),
                                    tint = Color.White
                                )
                            }


                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Arrow Drop Down",
                                modifier = Modifier
                                    .size(16.dp),
                                tint = Color.Green
                            )
                        }
                    },
                    track = {
                        val trackHeight = 13.dp
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(trackHeight)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(progress / 100f)
                                .height(trackHeight)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            MaterialTheme.colorScheme.primary,
                                            ProfileColor,
                                            MaterialTheme.colorScheme.primary
                                        )
                                    ),

                                    )
                        )
                    }
                )

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WallScreenPreview(){
    val navController = rememberNavController()
    WallScreen(navController = navController)
}



@Preview(showBackground = true)
@Composable
fun ProgressInfoPreview(){
    ProgressInfo(
        icon = painterResource(R.drawable.cover_etter),
        info = "About",
        progress = 70.0f
    )
}



