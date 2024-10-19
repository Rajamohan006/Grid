package com.example.grid.presentation.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.presentation.navigation.Screens
import com.example.grid.ui.theme.DarkBlue
import com.example.grid.ui.theme.Purple80
import kotlin.math.max

@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            CanvasBackground()

            Spacer(modifier = Modifier.height(60.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Welcome to Grid",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Lets guide and learn together",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Toggle between job categories to find opportunities tailored specifically for you.",
                    fontSize = 14.sp,
                    color = Color.Gray,

                )
                Spacer(modifier = Modifier.height(60.dp))

            }
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable { navController.navigate(Screens.SignInScreen.route){
                        popUpTo(Screens.WelcomeScreen.route){
                            inclusive = true
                        }
                    }
                    }
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                    Text(
                        text = "Lets Get Started",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    val navCoontroller = rememberNavController()
    WelcomeScreen(navCoontroller)
}
@Composable
fun CanvasBackground() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        // Large rotated blue background
        rotate(degrees = -29f) {
            drawRoundRect(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF003ACF), Color(0xFF2D4EA1)),
                    startY = 0f,
                    endY = 60.dp.toPx()
                ),
                size = size.copy(width = size.width + 250f),
                cornerRadius = CornerRadius(300f, 300f),
                topLeft = Offset(-100f, -200f)
            )
        }

        // Top-left small circle
        drawRoundRect(
            color = Color(0xFF2800C9),
            size = androidx.compose.ui.geometry.Size(200.dp.toPx(), 250.dp.toPx()),
            cornerRadius = CornerRadius(300f, 300f),
            topLeft = Offset(-100f, -70f)
        )

        // Top-right small rounded rectangle
        drawRoundRect(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF2D4EA1), Color(0xFF003ACF)),
                startY = 0f,
                endY = 60.dp.toPx()
            ),
            size = androidx.compose.ui.geometry.Size(200.dp.toPx(), 140.dp.toPx()),
            cornerRadius = CornerRadius(300f, 500f),
            topLeft = Offset(size.width - 500f, -70f) // Adjusted position
        )

        drawContext.canvas.nativeCanvas.apply {
            val paint = android.graphics.Paint().apply {
                isAntiAlias = true
                textSize = 200.sp.toPx()
                color = android.graphics.Color.WHITE
                textAlign = android.graphics.Paint.Align.CENTER
                typeface = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, android.graphics.Typeface.BOLD)
            }
            rotate(30f)
            drawText(
                "#",
                size.width / 2,
                size.height / 2 + 50f,
                paint
            )
        }
    }
}


