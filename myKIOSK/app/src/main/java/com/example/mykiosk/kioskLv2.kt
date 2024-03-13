package com.example.mykiosk
import kotlin.arrayOf

//lv 2
class Sandwich(var name: String = "베지", var price: Int = 4900){
    fun displayInfo(): Unit {
        println("${name}: ${price}")
    }
    companion object {
        fun desc() {
            println("")
            println("---[단품 샌드위치]---")
            println("1. 스파이시쉬림프 7,900원")
            println("2. 에그마요 5,500원")
            println("3. 베지 4,900원")
            println("0. 처음으로")
        }
    }
}
class Drink(var name: String = "탄산음료",var price: Int = 2000) {
    fun displayInfo(): Unit {
        println("${name}: ${price}")
    }

    companion object {
        fun desc() {
            println("")
            println("---[음료]---")
            println("1. 탄산음료 2,000원")
            println("2. 물 1,000원")
            println("0. 처음으로")
        }
    }
}
class Side(var name: String = "쿠키",var price: Int = 1300) {
    fun displayInfo(): Unit {
        println("${name}: ${price}")
    }

    companion object {
        fun desc() {
            println("")
            println("---[사이드]---")
            println("1. 쿠키 1,300원")
            println("2. 감자칩 1,300원")
            println("0. 처음으로")
        }
    }
}

fun descIntro(){
    println("===SpartanSUBWAY lv 2.==="); println("")
    println("안녕하세요! 서브웨이 내배캠 지점입니다. 원하는 메뉴를 선택하세요!")
    println("")
    println("---[서브웨이 메뉴]---")
    println("1. 단품 샌드위치")
    println("2. 음료")
    println("3. 사이드")
    println("0. 종료")
}
fun descMore(){
    println("더 주문하고 싶으신가요?")
    println("---[서브웨이 메뉴]---")
    println("1. 단품 샌드위치")
    println("2. 음료")
    println("3. 사이드")
    println("0. 종료")
    println("-1. 결제하기")
}
fun descEnd(price: Int){
    println(""); println("${price}원을 결제합니다.")
    println("결제가 완료되었습니다! 이용해주셔서 감사합니다."); println("")
    println("===SpartanSUBWAY lv 2.===")
}
fun main(){
    val sandwich = Sandwich()
    val drink = Drink()
    val side = Side()

    var receipt: Array<String> = arrayOf()
    var isBuying = true
    descIntro()
    var price: Int = 0
    while(isBuying){
        val getIntro = readln()
        if (getIntro == "0") break
        else if (getIntro == "-1") {isBuying = false; break}
        else if (getIntro == "1"){
            Sandwich.desc()
            when(readln()){
                "1" -> {println("스파이시 쉬림프 1개를 주문 목록에 추가했습니다."); price += 7900
                receipt += "스파이시 쉬림프 1 - 7,900원"}
                "2" -> {println("에그마요 1개를 주문 목록에 추가했습니다"); price += 5500
                receipt += "에그마요 1 - 5,500원"}
                "3" -> {println("베지 1개를 주문 목록에 추가했습니다"); price += 4900
                receipt += "베지 1 - 4,900원" }
                "0" -> continue

            }
        }
        else if(getIntro == "2"){
            Drink.desc()
            when(readln()){
                "1" -> {println("탄산음료 1잔을 주문 목록에 추가했습니다."); price += 2000
                    receipt += "탄산음료 1 - 2,000원"}
                "2" -> {println("생수 1병을 주문 목록에 추가했습니다."); price += 1000
                    receipt += "생수 1 - 1,000원"}
                "0" -> continue
            }
        }
        else if (getIntro == "3"){
            Side.desc()
            when(readln()){
                "1" -> {println("쿠키 1개를 주문 목록에 추가했습니다."); price += 1300
                    receipt += "쿠키 1 - 1,300원"}
                "2" -> {println("감자칩 1개를 주문 목록에 추가했습니다."); price += 1300
                    receipt += "감자칩 1 - 1,300원"}
                "0" -> continue
            }
        }
        println("결제 금액은 ${price}원 입니다.")
        println("")
        descMore()
    }


    receipt.forEach { println(it) }
    descEnd(price)
}
