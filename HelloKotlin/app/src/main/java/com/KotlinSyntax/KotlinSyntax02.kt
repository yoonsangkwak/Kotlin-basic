package com.KotlinSyntax

fun sum(x: Int, y: Int) = println(x + y) // 일반함수
val lambda = { x: Int, y: Int -> println(x + y) } // 람다함수
// { 매개변수 선언 -> 코드 작업 }
// 코드 작업 구간에서 마지막 줄은 자동으로 리턴 타입이됨

fun main(args: Array<String>) {
    sum(10, 20)
    lambda(10, 20)
}