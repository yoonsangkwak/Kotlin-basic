package com.HelloKotlin

fun main() {
    var a = People("박보영", 1990)
    var b = People("전정국", 1997)
    var c = People("장원영", 2004)

    var d = People("이루다")
    var e = People("차은우")
    var f = People("류수정")

    a.introduce()
    b.introduce()
    c.introduce()
}

class People (var name:String, val birthYear:Int) {
    init {
        println("${this.birthYear}년생 ${this.name}님이 생성되었습니다.")
    }

    constructor(name:String) : this(name, 1997) {
        println("보조 생성자가 사용되었습니다.")
    }

    fun introduce() {
        println("안녕하세요, ${birthYear}년생 ${name}입니다.")
    }
}