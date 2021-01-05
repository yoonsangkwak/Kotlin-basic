package com.NewHelloKotlin

fun main() {
    nullcheck()
    ignoreNulls("hi")
}

fun nullcheck() {

    var name1 : String = "joyce"
    var name2 : String = "jayce"
    var nullName : String? = null

    var nameInUpperCase = name1.toUpperCase()
    var nullNameInUpperCase = nullName?.toUpperCase()

    val lastName1 : String? = null
    val lastName2 : String? = "fullmetal"
    val fullName1 = name1 + " " + (lastName1 ?: "No lastName")
    val fullName2 = name2 + " " + (lastName2 ?: "No lastName")
    println(fullName1)
    println(fullName2)
}

fun ignoreNulls(str : String?) {
    val mNotNull : String = str!!
    val upper = mNotNull.toUpperCase()

    val email : String? = "steve@apple.com"
    val email2 : String? = null
    email?.let {
        println("my email is ${email}")
    }
    email2?.let {
        println("my email2 is ${email2}")
    }
}