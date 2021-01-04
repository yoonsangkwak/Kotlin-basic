package com.HelloKotlin

fun main() {
    var a = 11

    if (a > 10) {
        println("a는 10보다 큽니다.")
    } else if (a == 10) {
        println("a는 10 같습니다.")
    } else {
        println("oh no")
    }

    doWhen(1)
    doWhen("yoonsang")
    doWhen(12L)
    doWhen(1.453)
    doWhen("kojo")

    println()

    doWhen2(1)
    doWhen2("yoonsang")
    doWhen2(13L)
    doWhen2(1.5353)
    doWhen2("kotilin")
}

fun doWhen(a: Any) {
    when (a) {
        1 -> println("1입니다.")
        "yoonsang" -> println("yoonsang입니다.")
        is Long -> println("long 타입")
        is Float -> "float ipnida"
        !is String -> println("문자열아님")
        else -> println("다 아님")
    }
}

fun doWhen2(a: Any) {
    var result = when(a) {
        1 -> "정수 1입니다"
        "yoonsang" -> "yoonsang hi"
        is Long -> "Long type"
        !is String -> "not string"
        else -> "default"
    }

    println(result)
}