package com.NewHelloKotlin

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a : Int)
// 2) return 값으로 사용할 수 있다.

// 람다의 기본정의
// val lamdaName : Type = {argumentList -> codeBody}

val square = {number : Int -> number * number}
val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age} years old"
}

fun main() {
    println(square(12))
    println(nameAge("chulsoo", 19))

    val a = "mark said "
    val b = "zook said "
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("moong", 34))

    println(calculateGrade(92))
    println(calculateGrade(41))
    println(calculateGrade(922))

    println()

    val lamda = {number : Double ->
        number == 4.3213
    }

    println(invokeLamda(lamda))
    println(invokeLamda({it > 3.14}))
    println(invokeLamda { it > 3.14 })
}


// 확장함수

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String {

    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"}
    return name.introduceMyself(age)
}


// 람다의 Return

val calculateGrade : (Int) -> String = {
    when (it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "amazing"
    }
}


// 람다를 표현하는 여러가지 방법

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.2343)
}