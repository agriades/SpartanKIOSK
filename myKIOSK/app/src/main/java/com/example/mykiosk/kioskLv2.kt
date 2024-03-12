package com.example.mykiosk
//[서브웨이 메뉴] 단계에서 0을 누르지 않으면 계속 반복
//제품 1개만 받는다. 나중에 메소드, 클래스로 깔끔히 나누면 이 루틴을 반복해서 결제 결정을 내리게 하면 된다.
//lv 1 구현 끝!



data class Sandwich(
    val name: String,
    val price: Int
)
fun main(){
    println("===SpartanSUBWAY lv 1.==="); println("")
    println("안녕하세요! 서브웨이 내배캠 지점입니다. 원하는 메뉴를 선택하세요!"); println("")
    var sandwich1 = Sandwich("스파이시 쉬림프", 7900)
    var sandwich2 = Sandwich("에그마요", 5600)
    var sandwich3 = Sandwich("베지", 4900)

    println(sandwich1.name)
}

