package com.onet.kanyefunquotes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteScreen(modifier: Modifier = Modifier) {
    val kanyeViewModel: MainViewModel = viewModel()
    val viewState by kanyeViewModel.quoteState

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Kanye Quotes") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { kanyeViewModel.fetchQuote() },
                containerColor = MaterialTheme.colorScheme.secondaryContainer, // Example color
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer   // Example color
            ) {
                Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Add Image at the top
            Image(
                painter = painterResource(id = R.drawable.kanye_image),  // Replace with your image resource
                contentDescription = "Kanye West",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(100.dp)), // Circular crop
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(
                        2.dp,
                        MaterialTheme.colorScheme.secondaryContainer, // Border color (same as button)
                        RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                when {
                    viewState.loading -> {
                        CircularProgressIndicator()
                    }
                    viewState.error != null -> {
                        Text(
                            "Error: ${viewState.error}",
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center
                        )
                    }
                    else -> {
                        Text(
                            text = viewState.quote,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}