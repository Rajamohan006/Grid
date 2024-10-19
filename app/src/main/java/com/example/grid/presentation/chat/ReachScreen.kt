package com.example.grid.presentation.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.grid.presentation.navigation.BottomNavigationBar
import com.example.grid.presentation.navigation.Screens

@Composable
fun ReachScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = Screens.ReachScreen.route,
                onItemSelected = {route ->
                    navController.navigate(route)
                }
            )
        }
    ) {paddingValues ->
        Column(modifier = Modifier.fillMaxSize()
            .padding(paddingValues)) {  }
    }
}