package com.onet.count_a_counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.onet.count_a_counter.ui.theme.Count_a_CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create a Counter Model View Instance
        val counterViewModel: CounterViewModel by viewModels()
        setContent {
            Count_a_CounterTheme {
                // A surface container using the 'background' color from the theme
                val backgroundColor = Color(0xFFF5EFFF)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = backgroundColor
                ) {
                    CounterApp(counterViewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(viewModel: CounterViewModel) {
    val buttonColor = Color(0xFFA294F9)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            // Display the current count
            BasicText(text = "Count: ${viewModel.count.value}")
            Spacer(modifier = Modifier.height(16.dp))
            // Increment button
            Button(
                onClick = { viewModel.increment() },
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
            ) {
                Text(text = "Increment")
            }

            // Decrement button
            Button(
                onClick = { viewModel.decrement() },
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
            ) {
                Text(text = "Decrement")
            }
        }
    }
}

