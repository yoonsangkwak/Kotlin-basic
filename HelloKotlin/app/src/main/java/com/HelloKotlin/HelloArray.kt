package com.HelloKotlin

fun main() {
    // 1. 배열
    var arr1 = listOf("1", "2") // 수정불가능
    var arr2 = mutableListOf("1", "2") // 수정가능
    arr2.add("3")

    // 2. 반복문
    for (item in arr1) {
        println(item)
    }
    for ((index, item) in arr2.withIndex()) {
        println("$index ㅋ $item")
    }

    // 3. casting - Any -> auto casting
    var hello: Any = "hello"
    if (hello is String) {
        var str: String = hello
    }
}