package com.example.grid.presentation.wall.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.ui.theme.DarkBlue
import com.example.grid.ui.theme.Greens
import com.example.grid.ui.theme.ProfileColor
import com.example.grid.ui.theme.Surfaceee
import com.example.grid.ui.theme.TextColor

@Composable
fun AboutScreen(navController: NavController) {
    var progress: Int = 40
    var aboutYou by remember { mutableStateOf("") }
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
                color = Greens,
                modifier = Modifier.align(Alignment.BottomEnd)
                    .padding(4.dp)
            )
        }
        Box(
            modifier = Modifier.padding(start = 35.dp,
                top = 90.dp)
        ){
            Image(
                painter = painterResource(R.drawable.avatar_5),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(78.dp)
                    .align(Alignment.TopStart)
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 200.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "About you",
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
            ProgressionBar(progress = 70f)
            Spacer(modifier = Modifier.height(42.dp))
            Text(
                text = "Tell about yourself",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = aboutYou,
                onValueChange = { aboutYou = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, color = Color.White)
                    .height(350.dp),
                shape = RoundedCornerShape(10.dp),
                placeholder = {
                    Text(text = "Write something about yourself...")
                },
                maxLines = 15
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${aboutYou.length} / 250 words Maximum",
                fontSize = 12.sp,
                color = if (aboutYou.length > 250) Color.Red else Color.Gray,
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Save",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressionBar(progress:Float) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Slider(
            value = progress,
            onValueChange = { newValue ->
                progress
            },
            valueRange = 0f..100f,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = Color.LightGray.copy(0.5f)
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
                            .background(DarkBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${progress.toInt()}%",
                            color = Color.White,
                            fontSize = 6.sp,
                            modifier = Modifier
                                .border(1.dp, color = DarkBlue, shape = CircleShape)

                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Drop Down",
                        modifier = Modifier
                            .size(16.dp),
                        tint = DarkBlue
                    )
                }
            },
            track = {
                val trackHeight = 13.dp
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(trackHeight)
                        .background(Color.LightGray.copy(0.5f))
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress / 100f)
                        .height(trackHeight)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    DarkBlue,
                                    MaterialTheme.colorScheme.primary
                                )
                            ),
                            shape = RoundedCornerShape(4.dp)
                        )
                )
            }
        )
    }
}


@Preview
@Composable
fun PreviewAboutScreen() {
    val navController = rememberNavController()
    AboutScreen(navController)
}