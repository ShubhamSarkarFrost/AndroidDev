package com.example.trackmyhabbit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource // Import for image resource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.trackmyhabbit.R
import com.example.trackmyhabbit.ui.theme.BackgroundOrange

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate("habit_list_screen"){
            popUpTo("splash_screen"){inclusive = true}
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundOrange), // Use your custom orange background
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Add the image here
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.habits), // Replace with your image resource
                contentDescription = "App Logo",
                modifier = Modifier.size(120.dp) // Adjust size as needed
            )

            Spacer(modifier = Modifier.height(16.dp)) // Space between image and text

            Text(
                text = "Habit Tracker",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // White text for contrast
            )
            Text(
                text = "Stay Consistent!",
                fontSize = 20.sp,
                color = Color.White.copy(alpha = 0.7f)
            )
        }
    }
}