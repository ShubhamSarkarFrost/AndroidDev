package com.onet.myfirstapp

fun main() {
    val secretNumber = 7
    var guess: Int?

    println("Guess the secret number between 1 and 10!")

    while (true) {
        print("Enter your guess: ")
        guess = readLine()?.toIntOrNull()

        if (guess == null) {
            println("Invalid input. Please enter a number.")
            continue
        }

        when {
            guess < secretNumber -> println("Too low! Try again.")
            guess > secretNumber -> println("Too high! Try again.")
            else -> {
                println("Congratulations! You guessed the secret number.")
                break
            }
        }
    }
}