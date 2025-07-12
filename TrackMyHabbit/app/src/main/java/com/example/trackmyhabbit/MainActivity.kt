package com.example.trackmyhabbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trackmyhabbit.data.AppDatabase
import com.example.trackmyhabbit.ui.theme.TrackMyHabbitTheme
import com.example.trackmyhabbit.viewmodel.HabbitViewModel
import com.example.trackmyhabbit.viewmodel.HabitViewModelFactory
import com.example.trackmyhabbit.screens.AddHabitScreen
import com.example.trackmyhabbit.screens.HabitListScreen
import com.example.trackmyhabbit.screens.SplashScreen


class MainActivity : ComponentActivity() {

    // Lazily initialize the database and ViewModel
    private val database by lazy { AppDatabase.getDatabase(applicationContext) }
    private val viewModel: HabbitViewModel by viewModels {
        HabitViewModelFactory(database.habitDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Install the splash screen
        installSplashScreen()

        setContent {
            TrackMyHabbitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HabitTrackerApp(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun HabitTrackerApp(viewModel: HabbitViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("habit_list_screen") {
            HabitListScreen(navController = navController, viewModel = viewModel)
        }
        composable("add_habit_screen") {
            AddHabitScreen(navController = navController, viewModel = viewModel)
        }
    }
}