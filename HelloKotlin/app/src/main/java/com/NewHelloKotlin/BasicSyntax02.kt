package com.NewHelloKotlin

fun main() {
    forAndWhile()
}

fun forAndWhile() {

    val students = arrayListOf("joyce", "james", "jenny", "jennifer")

    for (name in students) {
        println("${name}")
    }
    for ((index, name) in students.withIndex()) {
        println("${index+1}번째 학생 : ${name}")
    }

    var sum : Int = 0
    for (i in 1 until 100) { // 100미만
        sum += 1
    }
    println(sum)

    var index = 0
    while (index < 5) {
        println("current index : ${index}")
        index++
    }
}