package com.onet.kotlinclasses

fun main(){
    // creating object/ Instance of class dog
    var magnus = Dog("Daisy", "Pomerian");
    println("${magnus.name} is a breed of type ${magnus.breed}");
    println("A Year has Passed");
    magnus.age = 2
    println("${magnus.name} is a breed of type ${magnus.breed}");
}