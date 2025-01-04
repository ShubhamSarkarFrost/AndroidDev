package com.onet.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.onet.shoppinglist.ui.theme.ShoppingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                // A surface container using the 'background' color from the theme
                val surfaceColor = Color(0xFFFFF6E3)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = surfaceColor
                ) {
                    ShoppingListApp()
                }
            }
        }
    }
}


