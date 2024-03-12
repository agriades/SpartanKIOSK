package com.example.mykiosk
//lv2 작성 중
fun intro(){
    println("===SpartanSUBWAY lv 1.==="); println("")
    println("안녕하세요! 서브웨이 내배캠 지점입니다. 원하는 메뉴를 선택하세요!")
    println("")
}
fun menu(): String {
    println("---[서브웨이 메뉴]---")
    println("1. 단품 샌드위치")
    println("2. 음료")
    println("3. 사이드")
    println("0. 종료")
    return readln()
}
fun sandwich(): Int{
    val sandwich1 = Sandwich()
    val sandwich2 = Sandwich("에그마요", 7900)
    val sandwich3 = Sandwich("스파이시 쉬림프", 7900)
    println("---[단품 샌드위치]---")
    sandwich1.displayInfo("1")
    sandwich2.displayInfo("2")
    sandwich3.displayInfo("3")
    var price: Int = 0
    when(readln()){
        "1" -> price = sandwich1.price
        "2" -> price = sandwich2.price
        "3" -> price = sandwich3.price
    }
    return price
}
fun drink(): Int{
    val drink1 = Drink()
    val drink2 = Drink("물", 1000)
    println("---[음료]---")
    drink1.displayInfo("1")
    drink2.displayInfo("2")
    var price: Int = 0
    when (readln()){
        "1" -> price = drink1.price
        "2" -> price = drink2.price
    }
    return price
}
fun side(): Int{
    val side1 = Side()
    val side2 = Side("감자칩", 1300)
    println("---[사이드]---")
    side1.displayInfo("1")
    side2.displayInfo("2")
    var price: Int = 0
    when (readln()){
        "1" -> price = side1.price
        "2" -> price = side2.price
    }
    return price
}

class Sandwich constructor(var name: String = "베지", var price: Int = 4900){
    fun displayInfo(index: String): Unit {
        println("${index}. ${name}: ${price}")
    }
}
class Drink constructor(var name: String = "탄산음료", var price: Int = 2000){
    fun displayInfo(index: String): Unit {
        println("${index}. ${name}: ${price}")
    }
}
class Side constructor(var name: String = "쿠키", var price: Int = 1300){
    fun displayInfo(index: String): Unit {
        println("${index}. ${name}: ${price}")
    }
}
fun main(){
    var price: Int = 0
    var isKioskOn = true
    intro()
    while(isKioskOn){
        when(menu()) {
            "1" -> price += sandwich()
            "2" -> price += drink()
            "3" -> price += side()
            else -> break
        }
    }
    println("총 결제 가격은 ${price}입니다.")
}