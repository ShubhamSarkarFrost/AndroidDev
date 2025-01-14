package com.onet.stopawatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val backgroundColor = Color(0xFFF9F7F7)
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = backgroundColor
            ) {
                val stopwatchViewModel: StopwatchViewModel by viewModels()
                StopwatchApp(stopwatchViewModel)
            }
        }
    }
}

@Composable
fun StopwatchApp(viewModel: StopwatchViewModel) {
    val customFont = FontFamily(Font(R.font.pacificoregular)) // Replace with your font resource
    val buttonColor = Color(0xFF60EFB8)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // header of application
        Text(
            text = "Stop a' Watch",
            modifier = Modifier,
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = customFont
        )

        // Stopwatch Icon
        val stopwatchIcon: Painter =
            painterResource(id = R.drawable.ic_stopwatch) // Replace with your drawable resource
        Image(
            painter = stopwatchIcon,
            contentDescription = "Stopwatch Icon",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Counter Display
        val timeFormatted = viewModel.formatTime(viewModel.time.value)
        Text(
            text = "Time: $timeFormatted",
            modifier = Modifier,
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = customFont
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Start Button
        Button(
            onClick = { viewModel.start() },
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text(
                text = "Start", modifier = Modifier,
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = customFont
            )
        }

        // Stop Button
        Button(
            onClick = { viewModel.stop() },
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text(
                text = "Stop", modifier = Modifier,
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = customFont
            )
        }

        //Reset Button
        Button(
            onClick = { viewModel.reset() },
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text(
                text = "Reset", modifier = Modifier,
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = customFont
            )
        }

    }
}


