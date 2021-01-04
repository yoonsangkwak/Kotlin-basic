package com.NewHelloKotlin

fun main() {
    val c: (String)->Unit = { str -> println("$str 람다함수")}
    val d = {str: String -> println("$str 람다함수")}
    val e: (String)->Unit = { str ->
        println("$str 람다함수")
        println("여러 구문을")
        println("사용 가능합니다.")
    }
    b(c)
    b(d)
    b(e)

    val calculate:(Int, Int)->Int = { a, b ->
        println(a)
        println(b)
        a+b // 마지막 결과값 반환
    }

    val a: ()->Unit = {println("패러미터가 없다.")}
    val a2: (String)->Unit = { println("$it 람다함수")} // 패러미터 1개일 때 it으로 생략가능
}