package com.HelloKotlin

fun main() {
    var a: Int = 1234
    var b: String = a.toString()
    println(a)
    println(b)
    println(b is String)
}