package com.onet.mybookapp

fun main(){
    // creating object/ Instance of class dog
    val myBook = Book();
    print("My Book Title is ${myBook.Title} \n & is written by ${myBook.author} \n , published in year ${myBook.year}")
    val customBook = Book("Order of Phoneix", 2007, "J.K.Rowling" )
    print("My Book Title is ${customBook.Title} \n & is written by ${customBook.author} \n , published in year ${customBook.year}")

}