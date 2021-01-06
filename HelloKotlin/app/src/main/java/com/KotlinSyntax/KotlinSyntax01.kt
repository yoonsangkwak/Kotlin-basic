package com.KotlinSyntax

fun main(args: Array<String>) {
    var temp1 = GenericClass1<Int>()
    temp1.genericMethod(7)

    var temp2 = GenericClass1<String>()
    temp2.genericMethod("바보")

    var temp3 = GenericClass2(99)
    temp3.genericMethod1()
    var intVar = temp3.genericMethod2()
    println("intVar:" + intVar)

    var temp4 = GenericClass2("은행원")
    temp4.genericMethod1()
    var strVar = temp4.genericMethod2()
    println("strVar:" + strVar)

    var temp5 = GenericClass3<String, Int>()
    temp5.genericMethod("하이", 1000)

    var temp6 = GenericClass3<Int, Double>()
    temp6.genericMethod(9, 9.99)

    var temp7 = GenericClass4<String, String>("천사", "악마")
    temp7.genericMethod()

    var temp8 = GenericClass4<Int, Double>(1, 0.5)
    temp8.genericMethod()
}

// T 타입의 파라미터를 사용하는 Generic Class
class GenericClass1<T> {
    fun genericMethod(genericParameter: T) {
        println("genericParameter: ${genericParameter}")
    }
}

// T 타입의 변수를 가진 default 생성자를 가진 Generic Class
// 리턴 타입도 정해줄 수 있다.
class GenericClass2<T>(genericVar: T) {
    var genericVar = genericVar

    fun genericMethod1() {
        println("genericVar: ${genericVar}")
    }

    fun genericMethod2(): T {
        return genericVar
    }
}

// T1, T2 타입의 파라미터를 사용하는 Generic Class
class GenericClass3<T1, T2> {
    fun genericMethod(genericParameter1: T1, genericParameter2: T2) {
        println("genericParameter1: ${genericParameter1}")
        println("genericParameter2: ${genericParameter2}")
    }
}

// T1, T2 타입의 변수를 가진 default 생성자를 가진 Generic Class
class GenericClass4<T1, T2> (genericVar1: T1, genericVar2: T2) {
    var genericVar1 = genericVar1
    var genericVar2 = genericVar2

    fun genericMethod() {
        println("genericVar1: ${genericVar1}")
        println("genericVar2: ${genericVar2}")
    }
}







