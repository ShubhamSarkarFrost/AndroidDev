package com.onet.myfirstapp

data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)

fun main(){
    val coffeeForDennis = CoffeeDetails(0,"Dennis","xxl", 0);
    coffeeMachine(coffeeForDennis);
}

//fun askForDetails() {
//    println("Who is this Coffee For ?");
//    var usersName: String = readln();
//    println("Hi $usersName Welcome to Coffee Machine ☕")
//    println("Please Enter the cups of sugar you want in your coffee !!")
//    var sugarCount: Int = readln().toInt();
//    coffeeMachine(sugarCount, usersName)
//}

fun coffeeMachine(coffeeDetails: CoffeeDetails) {
    if (coffeeDetails.sugarCount == 1) {
        print("Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name}")
    } else if (coffeeDetails.sugarCount < 1) {
        print("Coffee without any sugar for ${coffeeDetails.name}")
    } else {
        print("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}")
    }
}
