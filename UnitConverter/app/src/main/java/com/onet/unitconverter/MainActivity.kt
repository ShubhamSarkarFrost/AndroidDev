package com.onet.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onet.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}


@Composable
fun UnitConverter() {
    // variables to store the value
    var inputValue by remember{ mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Metres") }
    var outputUnit by remember { mutableStateOf("Metres") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oconversionFactor = remember { mutableStateOf(1.00) }

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Cursive,
        fontSize = 18.sp,
        color = Color(0xFF8A2BE2),
        fontWeight = FontWeight.Bold
    )

    fun conversionUnits(){
        //?: - Elvis Operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100 / oconversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    // Center all elements using a Box with Center alignment
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Ensure Column elements are centered horizontally
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.exchnage), // Replace with your image name
                contentDescription = "Unit Converter Image", // Accessibility description
                modifier = Modifier
                    .size(128.dp) // Adjust image size
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Unit Converter",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp),
                style = customTextStyle
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = inputValue, onValueChange = {
                inputValue = it
                conversionUnits()
            },
                label = {Text("Enter Value")})
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                //Input Box
                Box {
                    // Input Button
                    Button(
                        onClick = { iExpanded= true }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF8A2BE2)
                        ), shape = RoundedCornerShape(50)
                    ) {
                        Text(text = inputUnit)
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    }
                    DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded=false }) {
                        DropdownMenuItem(text = { Text("Centimetres") }, onClick = {
                            iExpanded=false
                            inputUnit = "Centimetres"
                            conversionFactor.value = 0.01
                            conversionUnits()
                        }
                        )
                        DropdownMenuItem(text = { Text("Meters") }, onClick = {
                            iExpanded=false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                            conversionUnits()
                        })
                        DropdownMenuItem(text = { Text("Feet") }, onClick = {
                            iExpanded=false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            conversionUnits()
                        })
                        DropdownMenuItem(text = { Text("Millimetres") }, onClick = {
                            iExpanded=false
                            inputUnit = "Millimetres"
                            conversionFactor.value = 0.001
                            conversionUnits()
                        })
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                //Output Box
                Box {
                    // Output Button
                    Button(
                        onClick = { oExpanded=true }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF8A2BE2)
                        ), shape = RoundedCornerShape(50)
                    ) {
                        Text(text = outputUnit)
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    }
                    DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded=false }) {
                        DropdownMenuItem(text = { Text("Centimetres") }, onClick = {
                            iExpanded=false
                            outputUnit = "Centimetres"
                            oconversionFactor.value = 0.01
                            conversionUnits()
                        })
                        DropdownMenuItem(text = { Text("Meters") }, onClick = {
                            iExpanded=false
                            outputUnit = "Meters"
                            oconversionFactor.value = 1.0
                            conversionUnits()
                        })
                        DropdownMenuItem(text = { Text("Feet") }, onClick = {
                            iExpanded=false
                            outputUnit = "Feet"
                            oconversionFactor.value = 0.3048
                            conversionUnits()
                        })
                        DropdownMenuItem(text = { Text("Millimetres") }, onClick = {
                            iExpanded=false
                            outputUnit = "Millimetres"
                            oconversionFactor.value = 0.001
                            conversionUnits()
                        })
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Result: ${outputValue} ${outputUnit}",
                style = MaterialTheme.typography.headlineSmall
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}