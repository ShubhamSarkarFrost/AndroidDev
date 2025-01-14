package com.onet.inheritance_android

class Offspring: Secondary(), Archery, Singer {

    override fun archery() {
        super.archery()
        println("Skill of Archery Learned")
    }

    override fun sing() {
        super.sing()
        println("Skill of Singing Learned")
    }
}