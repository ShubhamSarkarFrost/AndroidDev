package com.onet.myfirstapp

fun main() {
    println("Welcome to the Simple Arithmetic Calculator!")
    println("Type 'exit' to quit.")

    while (true) {
        print("\nEnter the first number: ")
        val firstNumber = readLine()?.toDoubleOrNull()
        if (firstNumber == null) {
            println("Invalid input. Please enter a valid number.")
            continue
        }

        print("Enter an operator (+, -, *, /): ")
        val operator = readLine()
        if (operator !in listOf("+", "-", "*", "/")) {
            println("Invalid operator. Please choose +, -, *, or /.")
            continue
        }

        print("Enter the second number: ")
        val secondNumber = readLine()?.toDoubleOrNull()
        if (secondNumber == null) {
            println("Invalid input. Please enter a valid number.")
            continue
        }

        if (operator == "/" && secondNumber == 0.0) {
            println("Division by zero is not allowed. Try again.")
            continue
        }

        val result = when (operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> 0.0 // This case will never happen due to earlier validation
        }

        println("Result: $firstNumber $operator $secondNumber = $result")
        println("Type 'exit' to quit or press Enter to continue.")
        if (readLine()?.lowercase() == "exit") {
            println("Goodbye!")
            break
        }
    }
}