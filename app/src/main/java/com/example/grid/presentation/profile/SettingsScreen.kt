package com.example.grid.presentation.profile

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.grid.R
import com.example.grid.ui.theme.Surfaceee

@Composable
fun SettingsScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
            .padding(top = 25.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Surfaceee)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "back",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(verticalAlignment = Alignment.CenterVertically,) {
                Icon(
                    painter = painterResource(R.drawable.tdesign_setting),
                    contentDescription = "settings",
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            BoxField(text = "Accounts & Notification")
            Spacer(modifier = Modifier.height(16.dp))
            BoxField(text = "Privacy Policy")
            Spacer(modifier = Modifier.height(16.dp))
            BoxField(text = "Terms & Conditions")
            Spacer(modifier = Modifier.height(16.dp))
            BoxField(text = "New Version Update")
            Spacer(modifier = Modifier.height(16.dp))
            BoxField(text = "About")

            Spacer(modifier = Modifier.weight(1f))
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 42.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {  },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Log Out",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary
                )

                Icon(
                    painter = painterResource(id = R.drawable.fluent_power_24_filled),
                    contentDescription = "log out",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp) // Adjusted size for better visibility
                )
            }
        }

    }
}

@Composable
fun BoxField(
    text: String,
    onClick: () -> Unit = {}
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart,

        ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview(){
    val navController = rememberNavController()
    SettingsScreen(navController = navController )
}