package com.HelloKotlin

fun main() {
    // map - key, value
    var map1 = mapOf(Pair("name", "yoonsang"))
    var map2 = mutableMapOf<String, String>()
    map2.put("name", "yoonsang")
    map2.put("age", "26")

    println(map2.keys)
    println(map2.values)
    for (map in map1) {
        println(map.value)
        println(map.key)
    }
}