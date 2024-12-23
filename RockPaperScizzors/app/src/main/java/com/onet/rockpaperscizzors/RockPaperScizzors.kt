package com.onet.rockpaperscizzors

import kotlin.random.Random
import kotlin.system.exitProcess

fun main() {
    val choices = listOf("Rock", "Paper", "Scissors")

    println("Welcome to Rock-Paper-Scissors!")
    while (true) {
        println("\nEnter your choice (Rock, Paper, Scissors) or type 'Exit' to quit:")
        val userChoice = readlnOrNull();

        if (userChoice == "Exit") {
            println("Thanks for playing!")
            exitProcess(0)
        }

        if (userChoice !in choices) {
            println("Invalid choice. Please select Rock, Paper, or Scissors.")
            continue
        }

        val computerChoice = choices[Random.nextInt(choices.size)]
        println("Computer chose: $computerChoice")

        when {
            userChoice == computerChoice -> println("It's a tie!")
            userChoice == "Rock" && computerChoice == "Scissors" ||
                    userChoice == "Paper" && computerChoice == "Rock" ||
                    userChoice == "Scissors" && computerChoice == "Paper" -> {
                println("You win!")
            }
            else -> println("You lose!")
        }
    }
}
