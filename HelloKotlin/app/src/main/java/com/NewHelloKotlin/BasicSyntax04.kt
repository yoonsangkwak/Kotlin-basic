package com.NewHelloKotlin

fun main() {
//    val human = Human("jjas")
//    val who = Human()
//    val foo = Human("babo", 27)
//
//    human.eatingCake()
//
//    println("This human's name is ${human.name}")
//    println("This human's name is ${who.name}")
    val korean = Korean()
    korean.singASong()
}

open class Human constructor(val name : String = "Anonymous") {

    init {
        println("New human has been born!!")
    }

    constructor(name : String, age : Int) : this(name) {
        println("my name is ${name}, ${age} years old")
    }

    fun eatingCake() {
        println("${name} Says 'This is so Yummy!'")
    }

    open fun singASong() {
        println("Put your hands in the air")
    }
}

class Korean : Human() {
    override fun singASong() {
        super.singASong()
        println("lalala")
        println("hahaha I'm ${name}")
    }
}