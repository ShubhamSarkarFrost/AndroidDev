package com.onet.myfirstapp

fun main(){
    val number = 10

    // Simple if-else
    if (number > 0) {
        println("$number is positive")
    } else {
        println("$number is not positive")
    }

    // if-else if-else
    if (number > 0) {
        println("$number is positive")
    } else if (number < 0) {
        println("$number is negative")
    } else {
        println("$number is zero")
    }

    // if as an expression
    val message = if (number % 2 == 0) {
        "$number is even"
    } else {
        "$number is odd"
    }
    println(message)

    // Nested if-else
    val grade = 85
    val result = if (grade >= 90) {
        "A"
    } else if (grade >= 80) {
        "B"
    } else if (grade >= 70) {
        "C"
    } else {
        "F"
    }
    println("Your grade is $result")
}