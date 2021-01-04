package com.HelloKotlin

fun main() {
    println(add(5, 6, 7))
    println(add2(5, 6, 7))
}

fun add(a: Int, b:Int, c:Int): Int {
    return a + b + c
}

fun add2(a: Int, b:Int, c:Int) = a + b + c