package com.NewHelloKotlin

data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hasCode(), equals(), copy() 가 자동으로 만들어짐

class TicketNormal (val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main() {
    val ticketA = Ticket("KoreanAir", "peanut", "2021-01-05", 14)
    val ticketB = TicketNormal("KoreanAir", "peanut", "2021-01-05", 14)

    println(ticketA)
    println(ticketB)
}