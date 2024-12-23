package com.onet.myfirstapp

fun main(){
    /* Immutable List */
    //val shoppingList = listOf("Apple", "Orange", "Mango", "Pineapple", "Grapes");
    /* mutable List */
    val shoppingList = mutableListOf("Apple", "Orange", "Mango", "Pineapple", "Grapes")
    // Print the original list
    println("Original list: $shoppingList")

    // Add an element to the list
    shoppingList.add("Date")
    println("After adding an element: $shoppingList")

    // Remove an element from the list
    shoppingList.remove("Banana")
    println("After removing an element: $shoppingList")

    // Update an element in the list
    shoppingList[1] = "Blueberry"  // Index in a List
    println("After updating an element: $shoppingList")

    // using set method
    shoppingList.set(3,"JackFruit")

    //contains method
    if(shoppingList.contains("Mango")){
        shoppingList.add("Kiwi")
        shoppingList.remove("Mango")
    }else{
        shoppingList.add("Mango")
        shoppingList.remove("Kiwi")
    }

    //iterate through the list
    println("Iterating through the list")
    for(item in shoppingList){
        println(item)
    }
    //until for loop
    println("Iterating through Until for Loop")
    for(index in 0 until shoppingList.size){
        println("item ${shoppingList[index]} is at $index")
    }
    
}