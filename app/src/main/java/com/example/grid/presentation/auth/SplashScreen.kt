package com.example.grid.presentation.auth

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.presentation.navigation.Screens
import com.example.grid.ui.theme.Surfaceee
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun SplashScreen(navController: NavController) {
    var isSplashScreenVisible by remember { mutableStateOf(true) }

    val fadeOutAlpha by animateFloatAsState(
        targetValue = if (isSplashScreenVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)  // Fade-out animation
    )

    LaunchedEffect(Unit) {
        delay(5000)
        isSplashScreenVisible = false
        delay(1000)
        navController.navigate(Screens.WelcomeScreen.route) {
            popUpTo(Screens.SplashScreen.route) { inclusive = true }
        }
    }

    if (isSplashScreenVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Surfaceee),
            contentAlignment = Alignment.Center
        ) {
            // Display the application name
            Text(
                text = "Grid",
                fontSize = 112.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .alpha(fadeOutAlpha)
            )

            MultipleRandomCircles()
        }
    }
}

@Composable
fun MultipleRandomCircles() {

    val numCircles = Random.nextInt(2, 4)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        for (i in 0 until numCircles) {
            val size = Random.nextInt(100, 250).dp
            val offsetX: Dp
            val offsetY: Dp

            when (i) {
                0 -> {
                    offsetX = (-size / 2)
                    offsetY = (-size / 2)
                }
                1 -> {
                    offsetX = (250.dp - size / 2)
                    offsetY = (-size / 2)
                }
                2 -> {
                    offsetX = (-size / 2)
                    offsetY = (500.dp - size / 2)
                }
                else -> {
                    offsetX = (250.dp - size / 2)
                    offsetY = (500.dp - size / 2)
                }
            }

            Box(
                modifier = Modifier
                    .offset(offsetX, offsetY)
                    .size(size)
                    .clip(CircleShape)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                            )
                        )
                    )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}