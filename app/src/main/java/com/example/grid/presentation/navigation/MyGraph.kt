package com.example.grid.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.grid.R
import com.example.grid.presentation.auth.OTPScreen
import com.example.grid.presentation.auth.PersonalDetailsScreen
import com.example.grid.presentation.auth.SignInScreen
import com.example.grid.presentation.auth.SignUpScreen
import com.example.grid.presentation.auth.SplashScreen
import com.example.grid.presentation.auth.WelcomeScreen
import com.example.grid.presentation.chat.ReachScreen
import com.example.grid.presentation.home.ApplyScreen
import com.example.grid.presentation.home.CompanyDetailsScreen
import com.example.grid.presentation.home.FilterScreen
import com.example.grid.presentation.home.HomeScreen
import com.example.grid.presentation.notification.NotificationScreen
import com.example.grid.presentation.profile.ProfileScreen
import com.example.grid.presentation.profile.SettingsScreen
import com.example.grid.presentation.wall.WallScreen
import com.example.grid.presentation.wall.components.AboutScreen
import com.example.grid.presentation.wall.components.CertificationScreen
import com.example.grid.presentation.wall.components.ContactScreen
import com.example.grid.presentation.wall.components.CoverLetterScreen
import com.example.grid.presentation.wall.components.EducationScreen
import com.example.grid.presentation.wall.components.LanguageScreen
import com.example.grid.presentation.wall.components.PersonalInfoScreen
import com.example.grid.presentation.wall.components.SkillsScreen
import com.example.grid.presentation.wall.components.SocialProfileScreen

@Composable
fun MyGraph() {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf("home") }

        NavHost(
            navController = navController,
            startDestination = Screens.SplashScreen.route
        ) {
            composable(Screens.SplashScreen.route) {
                SplashScreen(navController)
            }
            composable(Screens.WelcomeScreen.route) {
                WelcomeScreen(navController)
            }
            composable(Screens.SignInScreen.route) {
                SignInScreen(navController)
            }
            composable(Screens.SignUpScreen.route) {
                SignUpScreen(navController)
            }
            composable(
                route = "${Screens.OTPScreen.route}/{number}",
                arguments = listOf(navArgument("number") { type = NavType.StringType })
            ) { navBackStackEntry ->
                val number = navBackStackEntry.arguments?.getString("number") ?: "000000"
                OTPScreen(navController = navController, number = number)
            }
            composable(Screens.PersonalDetailsScreen.route) {
                PersonalDetailsScreen(navController)
            }
            composable(Screens.HomeScreen.route) {
                HomeScreen(navController)
            }
            composable(Screens.FilterScreen.route) {
                FilterScreen(navController)
            }
            composable(Screens.ApplyScreen.route) {
                ApplyScreen(navController)
            }
            composable(Screens.CompanyDetailsScreen.route) {
                CompanyDetailsScreen(navController)
            }
            composable(Screens.SettingsScreen.route) {
                SettingsScreen(navController)
            }
            composable(Screens.ReachScreen.route) {
                ReachScreen(navController)
            }
            composable(Screens.WallScreen.route) {
                WallScreen(navController)
            }
            composable(Screens.AboutScreen.route) {
                AboutScreen(navController)
            }
            composable(Screens.CertificationScreen.route) {
                CertificationScreen(navController)
            }
            composable(Screens.ContactScreen.route) {
                ContactScreen(navController)
            }
            composable(Screens.CoverLetterScreen.route) {
                CoverLetterScreen(navController)
            }
            composable(Screens.EducationScreen.route) {
                EducationScreen(navController)
            }
            composable(Screens.LanguageScreen.route) {
                LanguageScreen(navController)
            }
            composable(Screens.PersonalInfoScreen.route) {
                PersonalInfoScreen(navController)
            }
            composable(Screens.SkillsScreen.route) {
                SkillsScreen(navController)
            }
            composable(Screens.SocialProfileScreen.route) {
                SocialProfileScreen(navController)
            }
            composable(Screens.NotificationScreen.route) {
                NotificationScreen(navController)
            }
            composable(Screens.ProfileScreen.route) {
                ProfileScreen(navController)
            }
            composable(Screens.SettingsScreen.route) {
                SettingsScreen(navController)
            }
        }
}
@Composable
fun BottomNavigationBar(
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(94.dp),
    ) {

        NavigationBar(
            modifier = Modifier
                .shadow(8.dp)
                .height(74.dp)
                .background(Color.White),
            containerColor = Color.White,

        ) {
            NavigationBarItem(
                selected = selectedItem == Screens.HomeScreen.route,
                onClick = { onItemSelected(Screens.HomeScreen.route) },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.home_svgrepo),
                        contentDescription = "Home",
                        tint = if (selectedItem == Screens.HomeScreen.route) MaterialTheme.colorScheme.primary else Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                },
                label = { Text("Home", fontSize = 10.sp, color = if (selectedItem == Screens.HomeScreen.route) MaterialTheme.colorScheme.primary else Color.Gray) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,  // Remove indicator background
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray

                ),
                modifier = Modifier
                    .height(46.dp)
                    .align(Alignment.Bottom)
            )

            NavigationBarItem(
                selected = selectedItem == Screens.ReachScreen.route,
                onClick = { onItemSelected(Screens.ReachScreen.route) },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.chat),
                        contentDescription = "Chat",
                        tint = if (selectedItem == Screens.ReachScreen.route) MaterialTheme.colorScheme.primary else Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                },
                label = { Text("Chat", fontSize = 10.sp, color = if (selectedItem == Screens.ReachScreen.route) MaterialTheme.colorScheme.primary else Color.Gray) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,  // Remove indicator background
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray

                )
                ,
                modifier = Modifier
                    .height(46.dp)
                    .align(Alignment.Bottom)
            )

            Spacer(modifier = Modifier.weight(1f))
            NavigationBarItem(
                selected = selectedItem == Screens.NotificationScreen.route,
                onClick = { onItemSelected(Screens.NotificationScreen.route) },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.notification),
                        contentDescription = "Notifications",
                        tint = if (selectedItem == Screens.NotificationScreen.route) MaterialTheme.colorScheme.primary else Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                },
                label = { Text("Notifications", fontSize = 10.sp, color = if (selectedItem == Screens.NotificationScreen.route) MaterialTheme.colorScheme.primary else Color.Gray) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,  // Remove indicator background
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray

                ), modifier = Modifier
                    .height(46.dp)
                    .align(Alignment.Bottom)
            )


            NavigationBarItem(
                selected = selectedItem == Screens.ProfileScreen.route,
                onClick = { onItemSelected(Screens.ProfileScreen.route) },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "Profile",
                        tint = if (selectedItem == Screens.ProfileScreen.route) MaterialTheme.colorScheme.primary else Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                },
                label = { Text("Profile", fontSize = 10.sp, color = if (selectedItem == Screens.ProfileScreen.route) MaterialTheme.colorScheme.primary else Color.Gray) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,  // Remove indicator background
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray

                ),
                modifier = Modifier
                    .height(46.dp)
                    .align(Alignment.Bottom)
            )
        }


        FloatingActionButton(
            onClick = { onItemSelected(Screens.WallScreen.route) },
            modifier = Modifier
                .offset(y = (-4).dp)
                .size(89.dp)
                .align(Alignment.BottomCenter)
                .clip(CircleShape)
                .background(Color.White)
            ,
        ) {
            Box(
                modifier = Modifier.size(80.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                ,
                contentAlignment = Alignment.Center

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.wallfill),
                        contentDescription = "Wall",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)

                    )
                    Text(
                        text = "wall",
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Abcdef(){
    BottomNavigationBar(
        selectedItem = Screens.ProfileScreen.route,
        onItemSelected = {}
    )
}