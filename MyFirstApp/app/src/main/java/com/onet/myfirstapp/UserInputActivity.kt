package com.onet.myfirstapp

fun main() {
    // Prompt the user for their name
    println("Enter your name:")
    val name = readln() // Reads a line of input from the user

    // Prompt the user for their age
    println("Enter your age:")
    val age = readln().toInt() // Convert the input to an integer

    // Output the information
    println("Hello, $name! You are $age years old.")
}
