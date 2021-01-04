package com.NewHelloKotlin

fun main() {

    var price = 5000

    var a = Book("코틀린 책", 10000).apply {
        name = "[초특가]" + name
        discount()
    }
    // apply / also : 처리가 끝나면 인스턴스를 반환
    // run / let : 처리가 끝나면 최종값을 반환

    a.run {
        println("상품명: ${name}, 가격: ${price}원")
    }
    a.let {
        println("상품명: ${it.name}, 가격: ${it.price}원")
    }
}

class Book(var name:String, var price:Int) {
    fun discount() {
        price -= 2000
    }
}