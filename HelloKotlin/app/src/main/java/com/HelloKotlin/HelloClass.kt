package com.HelloKotlin

fun main() {
    // 클래스 : 유사 기능들의 집합체

    // 1. class - 자동차(시동, 운전), 사람(밥먹기, 물마시기, 걷기)
    // 2. data class - get, set 동작을 간편하게 구현

    var cls = HelloClass()
    println(cls.age)
    var cls2 = HelloClass(26)
    println(cls2.age)
    var person = Person(1, "baby")
    println(person.age)
    println(person.name)
}

class HelloClass {
    var age: Int = 0
    init {

    }

    // default 생성자, 보조생성자
    constructor() // 생성자
    constructor(age: Int) {
        this.age = age
    } // 보조생성자
}

data class Person(var age: Int, val name: String)