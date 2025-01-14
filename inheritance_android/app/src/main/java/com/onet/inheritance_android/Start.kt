package com.onet.inheritance_android

fun main(){
   val objone = BaseClass()
    objone.coreValues()
    objone.role()

    val objtwo = Secondary()
    objtwo.coreValues()
    objtwo.role()

    val objThree = Offspring()
    objThree.role()
    objThree.coreValues()
    objThree.archery()
    objThree.sing()
}