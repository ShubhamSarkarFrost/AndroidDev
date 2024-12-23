package com.onet.myfirstapp

fun main(){

    println("Welcome to Coffee ☕ Maker application !!");
    println("Enter the ingredient you have and we will try to make a different coffee for you !!");

    println("Please Enter amount of Water in ML ?");
    val water = readln()?.toIntOrNull();

    print("Amount of milk (in ml): ")
    val milk = readLine()?.toIntOrNull()

    if (water == null || milk == null || water < 0 || milk < 0) {
        println("Invalid input. Please enter positive numbers for water and milk.")
        return
    }

    makeCoffee(water, milk)

}

fun makeCoffee(water: Int, milk: Int) {

    when {
        water >= 30 && milk == 0 -> println("- Espresso (30 ml water needed)")
        water >= 100 && milk == 0 -> println("- Americano (100 ml water needed)")
        water >= 30 && milk >= 150 -> println("- Latte (30 ml water, 150 ml milk needed)")
        water >= 30 && milk >= 50 -> println("- Cappuccino (30 ml water, 50 ml milk needed)")
        water >= 30 && milk >= 100 -> println("- Mocha (30 ml water, 100 ml milk needed)")
        else -> println("Not enough ingredients for any coffee. Please add more milk or water.")
    }
}
