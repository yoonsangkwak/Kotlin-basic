package com.KotlinSyntax

fun main(args: Array<String>) {
    // 람다 함수를 이용하여 함수 전달
    result("고차함수 ", { x, y -> x + y })
}

// sum: (Int, Int) -> Int
// 함수명: (매개변수 타입) -> 리턴 타입
fun result(str: String, sum: (Int, Int) -> Int) {
    println(str + sum(10, 20))
}