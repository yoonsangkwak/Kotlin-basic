package com.HelloKotlin

fun main() {
    var a = Animal("별이", 5, "개")
    var b = Dog("별이", 5)
    var c = Cat("달리", 3)

    a.introduce()
    b.introduce()
    b.bark()
    c.introduce()
    c.meow()
}

open class Animal (var name:String, var age:Int, var type:String) {
    fun introduce() {
        println("저는 ${type} ${name}이고, ${age}살 입니다.")
    }
}

class Dog (name:String, age:Int) : Animal (name, age, "개") {
    fun bark() {
        println("멍멍")
    }
}

class Cat (name:String, age:Int) : Animal (name, age, "고양이") {
    fun meow() {
        println("야옹")
    }
}