package com.example.grid.presentation.wall.components

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
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
import com.example.grid.ui.theme.Greens
import com.example.grid.ui.theme.ProfileColor
import com.example.grid.ui.theme.Surfaceee
import com.example.grid.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController) {
    var progress: Int = 40
    var phoneNumber by remember { mutableStateOf("") }
    var emailId by remember { mutableStateOf("") }
    var otpVerify by remember { mutableStateOf("") }
    var isPhoneSelected by remember { mutableStateOf(true) }
    var isVerified by remember { mutableStateOf(false) }
    val isSelected by remember { mutableStateOf(true) }

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
                .padding(start = 16.dp, top = 190.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Contact",
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
            ProgressionBar(progress  = 80f)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .clip(CircleShape)
                        .background(color = if (isSelected) Color(0xFFC7B7FF) else Color.Gray.copy(0.5f))
                        .clickable {
                            isPhoneSelected = true
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Phone Number",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start =  8.dp, end = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .clip(CircleShape)
                        .clickable {
                            isPhoneSelected = false
                        }
                        .background(color = if (isSelected) Color(0xFFC7B7FF) else Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Email",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start =  8.dp, end = 8.dp)
                    )
                }
            }

            if (isPhoneSelected) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(text = "Phone number", fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
                TextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Recruiters will contact you on this number",
                    fontSize = 10.sp,
                    color = TextColor
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Verify",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            isVerified = true
                        }
                )

                if (isVerified) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "Enter OTP", fontSize = 14.sp)
                    TextField(
                        value = otpVerify,
                        onValueChange = { otpVerify = it },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Gray,
                            unfocusedIndicatorColor = Color.Gray
                        )
                    )
                }
            } else {

                Spacer(modifier = Modifier.height(28.dp))
                Text(text = "Email ID", fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
                TextField(
                    value = emailId,
                    onValueChange = { emailId = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "We will send relevant jobs and updates to this email",
                    fontSize = 10.sp,
                    color = TextColor
                )
                Spacer(modifier = Modifier.height(4.dp))


                Text(
                    text = "Verify",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            isVerified = true
                        }
                )


                if (isVerified) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "Enter OTP", fontSize = 14.sp)
                    TextField(
                        value = otpVerify,
                        onValueChange = { otpVerify = it },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Gray,
                            unfocusedIndicatorColor = Color.Gray
                        )
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ContactScreenPreview(){
    val navController = rememberNavController()
    ContactScreen(navController = navController)
}