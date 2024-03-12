package com.example.mykiosk
//lv2 작성 중

class Sandwich constructor(var name: String = "베지", var price: Int = 4900){
    fun displayInfo(): Unit {
        println("${name}: ${price}")
    }
}

class Drink constructor(var name: String = "탄산음료", var price: Int = 2000){
    fun displayInfo(): Unit {
        println("${name}: ${price}")
    }
}

class Side constructor(var name: String = "쿠키", var price: Int = 1300){
    fun displayInfo(): Unit {
        println("${name}: ${price}")
    }
}

fun main(){
    val sandwich1 = Sandwich()
    val sandwich2 = Sandwich("에그마요", 7900)
    val sandwich3 = Sandwich("스파이시 쉬림프", 7900)
    println(sandwich1.name)
    println(sandwich2.name)
    sandwich1.displayInfo()
}