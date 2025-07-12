package com.example.trackmyhabbit.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.trackmyhabbit.R // Will need to create a drawable for default image
import com.example.trackmyhabbit.data.Habbit
import com.example.trackmyhabbit.ui.theme.BackgroundOrange
import com.example.trackmyhabbit.ui.theme.OrangeDark
import com.example.trackmyhabbit.ui.theme.OrangePrimary
import com.example.trackmyhabbit.viewmodel.HabbitViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitListScreen(navController: NavController, viewModel: HabbitViewModel) {
    val habits by viewModel.habits.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Habit Tracker", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = OrangePrimary)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_habit_screen") },
                containerColor = OrangeDark, // Darker orange for FAB
                contentColor = Color.White
            ) {
                Icon(Icons.Filled.Add, "Add new habit")
            }
        },
        containerColor = BackgroundOrange // Set scaffold background to orange
    ) { paddingValues ->
        if (habits.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No habits yet! Click '+' to add one.",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(habits) { habit ->
                    HabitItem(habit = habit, onHabitClick = {
                        viewModel.incrementHabbitCounter(it)
                    })
                }
            }
        }
    }
}

@Composable
fun HabitItem(habit: Habbit, onHabitClick: (Habbit) -> Unit) {
    val progress = if (habit.targetCount > 0) habit.currentCount.toFloat() / habit.targetCount else 0f
    val sweepAngle = progress * 360f

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Makes the card square
            .clip(CircleShape) // Clip the card to a circle
            .clickable { onHabitClick(habit) },
        colors = CardDefaults.cardColors(containerColor = OrangeDark), // Darker orange for habit items
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Background circle for progress indicator
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = Color.White.copy(alpha = 0.1f), // Light background for the ring
                    radius = size.minDimension / 2 - 8.dp.toPx(),
                    style = Stroke(width = 8.dp.toPx())
                )
                // Progress arc
                drawArc(
                    color = Color.White, // White color for progress
                    startAngle = -90f,
                    sweepAngle = sweepAngle.coerceAtMost(360f), // Cap at 360 degrees
                    useCenter = false,
                    style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                // Habit Icon/Image
                if (!habit.imageURL.isNullOrEmpty()) {
                    Image(
                        painter = rememberAsyncImagePainter(habit.imageURL),
                        contentDescription = habit.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(Color.Gray.copy(alpha = 0.2f)) // Placeholder background
                    )
                } else {
                    // Default icon if no image URL is provided
                    Icon(
                        painter = painterResource(id = R.drawable.ic_default_habit), // Placeholder default icon
                        contentDescription = habit.name,
                        modifier = Modifier.size(64.dp),
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Counter Text
                Text(
                    text = habit.currentCount.toString(),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Habit Name
                Text(
                    text = habit.name.uppercase(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center,
                    lineHeight = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
