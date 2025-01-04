package com.onet.shoppinglist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    val id: Int,
    var name: String,
    var quantity: Int,
    var isEditing: Boolean = false
)
val textcolor = Color(0xFFBFECFF)
val customTextStyle = FontFamily(Font(R.font.my_custom_font, FontWeight.SemiBold))

@Composable
fun ShoppingListApp() {
    val buttonColor = Color(0xFFCDC1FF)
    val alertColor = Color(0xFFBFECFF)
    val alertButtonColor = Color(0xFF0A5EB0)
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }


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
            Image(
                painter = painterResource(id = R.drawable.carticon),
                contentDescription = "cart icon",
                modifier = Modifier
                    .size(165.dp)
                    .padding(bottom = 16.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                shape = RoundedCornerShape(50)

            ) {
                Text(text = "🛒 : Add", color = textcolor, fontFamily = customTextStyle)
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(sItems) {
                    ShoppingListItem(it,{},{})
                }
            }
            if (showDialog) {
                AlertDialog(onDismissRequest = { showDialog = false },
                    confirmButton = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    if (itemName.isNotBlank()) {
                                        val newItem = ShoppingItem(
                                            id = sItems.size + 1,
                                            name = itemName,
                                            quantity = itemQuantity.toInt()
                                        )
                                        sItems = sItems + newItem
                                        showDialog = false
                                        itemName = ""
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = alertButtonColor),
                            ) {
                                Text(text = "Add", fontFamily = customTextStyle)
                            }
                            Button(
                                onClick = { showDialog = false },
                                colors = ButtonDefaults.buttonColors(containerColor = alertButtonColor)
                            ) {
                                Text(text = "Cancel", fontFamily = customTextStyle)
                            }
                        }
                    },
                    title = { Text(text = "Add Shopping Item", fontFamily = customTextStyle) },
                    containerColor = alertColor,
                    text = {
                        Column {
                            OutlinedTextField(
                                value = itemName,
                                onValueChange = { itemName = it },
                                label = { Text(text = "Enter text", fontFamily = customTextStyle) },
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )

                            OutlinedTextField(
                                value = itemQuantity,
                                onValueChange = { itemQuantity = it },
                                label = {
                                    Text(
                                        text = "Enter Quantity",
                                        fontFamily = customTextStyle
                                    )
                                },
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )


                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    onEditClick: () -> Unit,  // this is a lambda function
    onDeleteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .border(
                border = BorderStroke(width = 2.dp, Color(0xFF578E7E)),
                shape = RoundedCornerShape(20)
            )
    ) {
        Text(text = item.name, modifier = Modifier.padding(8.dp), color = textcolor , fontFamily = customTextStyle)
    }
}
