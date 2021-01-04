package com.NewHelloKotlin

fun main() {
    b(::a) // :: -> 일반 함수를 고차 함수로 변경해 주는 연산자
}

fun a (str: String) {
    println("$str 함수 a")
}

fun b (function: (String)->Unit) {
    function("b가 호출한")
}