package com.HelloKotlin

fun main() {
    var a = 0
    var a2 = 0

    while (a < 5) {
        print(a++)
        print(",")
        println(++a2)
    }

    println()

    var b = 0
    var b2 = 0
    do {
        print(b++)
        print(",")
        println(++b2)
    } while (b < 5)

    println()

    for (i in 0..9) {
        println(i)
    }

    println()

    for (i in 0..9 step 3) {
        println(i)
    }

    println()

    for (i in 9 downTo 0) {
        print(i)
    }

    println()

    for (i in 'a'..'e') {
        print(i)
    }
}