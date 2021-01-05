package com.NewHelloKotlin

class Book2 private constructor(val id : Int, val name : String) {

    companion object BookFactory : IdProvider {
        override fun getId(): Int {
            return 444
        }

        val myBook = "new book"
        fun create() = Book2(getId(), myBook)
    }
}

interface IdProvider {
    fun getId() : Int
}

fun main() {
    val book = Book2.create()

    val bookId = Book2.BookFactory.getId()
    println("${book.id} ${book.name}")
}