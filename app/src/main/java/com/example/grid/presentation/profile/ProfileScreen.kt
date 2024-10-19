package com.example.grid.presentation.profile

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.presentation.navigation.BottomNavigationBar
import com.example.grid.presentation.navigation.Screens
import com.example.grid.ui.theme.Surfaceee

@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    val name = remember { mutableStateOf("Swetha") }

    Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    selectedItem = Screens.HomeScreen.route,
                    onItemSelected = {route ->
                        navController.navigate(route)
                    }
                )
            }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Ensure paddingValues from Scaffold is applied
                .background(Surfaceee)
                .padding(horizontal = 16.dp, vertical = 10.dp) // Only use necessary additional padding
        ) {
            Spacer(modifier = Modifier.height(47.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = name.value,
                            fontSize = 24.sp,
                            color = Color(0xFF161616)
                        )
                        Spacer(modifier = Modifier.height(21.dp))
                        Text(
                            text = "Profile: 75%",
                            fontSize = 16.sp,
                            color = Color(0xFF161616)
                        )
                        Spacer(modifier = Modifier.height(9.dp))
                        Text(
                            text = "Go to Wall to Complete",
                            fontSize = 13.sp,
                            color = Color(0xFF5A5A5A)
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.avatar_5),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(82.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                JobsCount(count = 244, label = "Viewed Jobs")
                JobsCount(count = 244, label = "Saved Jobs")
                JobsCount(count = 244, label = "Profile Viewed")
                JobsCount(count = 244, label = "Recruiter Actions")
            }

            Spacer(modifier = Modifier.height(40.dp))

            ProfileBoxField(text = "Switch to Recruiter", icon = painterResource(R.drawable.vector), onClick = {})
            Spacer(modifier = Modifier.height(20.dp))
            ProfileBoxField(text = "Contact Us", icon = painterResource(R.drawable.material_symbols_call_outline), onClick = {})
            Spacer(modifier = Modifier.height(20.dp))
            ProfileBoxField(text = "Settings", icon = painterResource(R.drawable.tdesign_setting), onClick = {
                navController.navigate("settings")
            })
            Spacer(modifier = Modifier.height(6.dp))
        }
    }

}


@Composable
fun JobsCount(
    count: Int,
    label:String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF161616)
        )
    }
}

@Composable
fun ProfileBoxField(
    text: String,
    icon: Painter,
    onClick: () -> Unit = {}

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(6.dp)) {
            Icon(painter = icon, contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(22.dp)
                    .padding(start = 6.dp))
            Text(
                text = text,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 6.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    val navController= rememberNavController()
    ProfileScreen(navController)
}

