package com.onet.captainsgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.onet.captainsgame.ui.theme.CaptainsGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainsGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainsGame()
                }
            }
        }
    }
    @Composable
    fun CaptainsGame(){
        //val treasuresFound = remember{mutableStateOf(0)}
        var treasuresFound by remember{mutableStateOf(0)}
        val direction = remember{ mutableStateOf("North") }
        val stormOrTreasure = remember{ mutableStateOf("") }

        Column{
            Text(text="Treasure Found : $treasuresFound")
            Text("Current Direction : ${direction.value}")
            Text(text= stormOrTreasure.value)
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()){
                    treasuresFound +=1
                    stormOrTreasure.value = "Found a Treasure"
                }else{
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text("Sail East")
            }
            Button(onClick = {
                direction.value = "West"
                if(Random.nextBoolean()){
                    treasuresFound +=1
                    stormOrTreasure.value = "Found a Treasure"
                }else {
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text("Sail West")
            }
            Button(onClick = {
                direction.value = "South"
                if(Random.nextBoolean()){
                    treasuresFound +=2
                    stormOrTreasure.value = "Found a Treasure"
                }else{
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text("Sail South")
            }
            Button(onClick = {
                direction.value = "North"
                if(Random.nextBoolean()){
                    treasuresFound +=2
                    stormOrTreasure.value = "Found a Treasure"
                }else{
                    stormOrTreasure.value = "Storm Ahead!!"
                }
            }) {
                Text("Sail North")
            }
        }
    }
}
