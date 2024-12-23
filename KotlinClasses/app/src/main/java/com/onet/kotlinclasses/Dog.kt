package com.onet.kotlinclasses

class Dog(var name : String, var breed : String, var age : Int = 0) {  // the following is the constructor

    init {
        bark(name, breed, age)
    }
    // the following is the member function
    fun bark(name: String, breed: String, age: Int){
        println("Hi my name is $name my breed is $breed i do Woff Woff");
    }


}