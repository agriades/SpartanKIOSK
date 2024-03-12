package com.example.mykiosk
import android.util.Log

//[서브웨이 메뉴] 단계에서 0을 누르지 않으면 계속 반복
//제품 1개만 받는다. 나중에 메소드, 클래스로 깔끔히 나누면 이 루틴을 반복해서 결제 결정을 내리게 하면 된다.
//lv 1 구현 끝!

fun main(){
    var isKioskOn = true
    println("===SpartanSUBWAY lv 1.==="); println("")
    println("안녕하세요! 서브웨이 내배캠 지점입니다. 원하는 메뉴를 선택하세요!")
    println("")

    while(isKioskOn){
        var price: Int = 0

        println("---[서브웨이 메뉴]---")
        println("1. 단품 샌드위치")
        println("2. 음료")
        println("3. 사이드")
        println("0. 종료")
        val getIntro = readln()
        if (getIntro == "0") break
        else if (getIntro == "1"){
            println("---[단품 샌드위치]---")
            println("1. 스파이시쉬림프 7,900원")
            println("2. 에그마요 5,500원")
            println("3. 베지 4,900원")
            println("0. 처음으로")
            val getSandwich = readln()
            when(getSandwich){
                "1" -> price += 7900
                "2" -> price += 5500
                "3" -> price += 4900
                "0" -> continue

            }
        }
        else if(getIntro == "2"){
            println("---[음료]---")
            println("1. 탄산음료 2,000원")
            println("2. 물 1,000원")
            println("0. 처음으로")
            val getSandwich = readln()
            when(getSandwich){
                "1" -> price += 2000
                "2" -> price += 1000
                "0" -> continue
            }
        }
        else if (getIntro == "3"){
            println("---[사이드]---")
            println("1. 쿠키 1,300원")
            println("2. 감자칩 1,300원")
            println("0. 처음으로")
            val getSide = readln()
            when(getSide){
                "1" -> price += 1300
                "2" -> price += 1300
                "0" -> continue
            }
        }
        println("결제 금액은 ${price}원 입니다.")
    }
}
