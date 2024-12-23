package com.onet.myfirstapp

fun main(){

    val numOne = 1;
    /* numOne = 2; - Once a Value is assigned with val we cannot change its value */

    var usersAge = 29;
    usersAge = 45; /* var is a mutable reference */

    println("numOne is $numOne and UsersAge is $usersAge");

    /* manual assignment */
    val userAccountNo : Long = 4523632102356;
    println("User Account is : $userAccountNo");

    val pi: Float = 3.1415927f;
    val areaOfCircle = pi * 3.4 * 3.4;
    println("Area of Circle is : $areaOfCircle");

    val b: UByte = 1u  // UByte, "0 - 255"
    val s: UShort = 1u // UShort, "0 - 65,535"
    val l: ULong = 1u  // ULong, " 0 - 18,446,744,073,709,551,615 (264 - 1)"

    println(" UByte - $b \n UShort - $s \n ULong - $l");

    // Booleans
    val myTrue: Boolean = true
    val myFalse: Boolean = false
    val boolNull: Boolean? = null

    println(myTrue || myFalse) // true - disjunction
    println(myTrue && myFalse) // false - conjunction
    println(!myTrue) // false - negation
    println(boolNull) // null

    // characters
    val aChar: Char = 'a'

    println(aChar);
    println('\n'); // Prints an extra newline character
    println('\uFF00');

    //strings
    val firstName = "John"
    val lastName = "Doe"

    // Concatenation
    val fullName = "$firstName $lastName";
    println("Full Name: $fullName");

    // String interpolation
    val greeting = "Hello, $firstName $lastName!"
    println(greeting)

    // String methods
    val sampleText = "Kotlin Programming"
    println("Length: ${sampleText.length}");
    println("Uppercase: ${sampleText.uppercase()}");
    println("Lowercase: ${sampleText.lowercase()}");
    println("Contains 'Kotlin': ${sampleText.contains("Kotlin")}");
    println("Substring (0 to 6): ${sampleText.substring(0, 6)}");

    // Multiline string
    val multilineText = """
        Kotlin is fun!
        Strings are powerful.
        Enjoy coding.
    """.trimIndent()
    println(multilineText);
}