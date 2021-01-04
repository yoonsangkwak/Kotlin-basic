package com.HelloKotlin

fun main() {

    gugu@for (i in 1..10) {
        for (j in 1..10) {
            if (i == 2 && j ==3) break@gugu
            println("i : $i, j : $j")
        }
    }
}