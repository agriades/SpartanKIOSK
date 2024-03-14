package com.example.mykiosk
//샌드위치, 음료, 사이드 모두 먹을 수 있으므로 Edible이라는 부모 클래스의 자식으로 두어 볼까?
//https://www.subway.co.kr/menuList/sandwich
class Sandwiches {

    companion object {
        val breads = setOf("화이트", "하티", "파마산오레가노", "위트", "허니오트", "플랫")
        val cheeses = setOf("아메리칸", "슈레드", "모짜렐라")
        val veggies = setOf("양상추", "토마토", "오이", "피망", "양파")
        val pickles = setOf("피클", "올리브", "할라피뇨")
        val doubles = setOf("미트 추가", "치즈 추가")
        val toppings = setOf("에그마요", "베이컨", "에그 슬라이스", "오믈렛", "페퍼로니", "아보카도")
    }

}

fun main(){
    println(Sandwiches.breads)
}

