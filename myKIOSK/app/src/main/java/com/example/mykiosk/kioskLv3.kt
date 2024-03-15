package com.example.mykiosk
//샌드위치, 음료, 사이드 모두 먹을 수 있으므로 Edible이라는 부모 클래스의 자식으로 두어 볼까?
//https://www.subway.co.kr/menuList/sandwich

class Descriptions(){
    fun Intro(): String {
        println("===SpartanSUBWAY lv 2.==="); println("")
        println("안녕하세요! 서브웨이 내배캠 지점입니다. 원하는 메뉴를 선택하세요!")
        println("")
        println("---[서브웨이 메뉴]---")
        println("1. 단품 샌드위치")
        println("2. 음료")
        println("3. 사이드")
        println("0. 종료")
        return readln()
    }
    fun More(): String{
        println("더 주문하고 싶으신가요?")
        println("---[서브웨이 메뉴]---")
        println("1. 단품 샌드위치")
        println("2. 음료")
        println("3. 사이드")
        println("0. 종료")
        println("-1. 결제하기")
        return readln()
    }
    fun End(price: Int){
        println(""); println("${price}원을 결제합니다.")
        println("결제가 완료되었습니다! 이용해주셔서 감사합니다."); println("")
        println("===SpartanSUBWAY lv 2.===")
    }
}

open class Edible(var name: String ="상품명 표시 자리", var price: Int = 0){
    open fun desc(){
        println("---[설명이 들어갈 자리]---")
    }

    open val category = mapOf("상품명1" to 0, "상품명2" to 0)
    open fun select(): Pair<String, Int>{
        val number = readln() //주문번호
        return name to price
    }
    fun displayInfo(){
        println("${name}: ${price}")
    }


}
class Sandwiches() : Edible("베지", 4900) {
    override val category = mapOf("베지" to 4900, "에그마요" to 5500, "스파이시 쉬림프" to 7900 )
    override fun desc(){
        println("")
        println("---[단품 샌드위치]---")
        println("1. 스파이시쉬림프 7,900원")
        println("2. 에그마요 5,500원")
        println("3. 베지 4,900원")
        println("0. 처음으로")
    }
    override fun select(): Pair<String, Int>{
        when(readln()){ //주문번호
            "1" -> {name = "스파이시 쉬림프"; price = category["스파이시 쉬림프"]!!}
            "2" -> {name = "에그마요"; price = category["에그마요"]!!}
            "3" -> {name = "베지"; price = category["베지"]!!}
        }
        return name to price
    }
    companion object {
        val breads = setOf("화이트", "하티", "파마산오레가노", "위트", "허니오트", "플랫")
//        val cheeses = setOf("아메리칸", "슈레드", "모짜렐라")
//        val veggies = setOf("양상추", "토마토", "오이", "피망", "양파")
//        val pickles = setOf("피클", "올리브", "할라피뇨")
//        val doubles = setOf("미트 추가", "치즈 추가")
//        val toppings = setOf("에그마요", "베이컨", "에그 슬라이스", "오믈렛", "페퍼로니", "아보카도")
    }
}

class Drinks() : Edible("탄산음료",2000) {
    override val category = mapOf("탄산음료" to 2000, "물" to 1000)
    companion object {
        val sodas = setOf("콜라", "사이다", "제로콜라")
    }

    override fun desc() {
        println("")
        println("---[음료]---")
        println("1. 탄산음료 2,000원")
        println("2. 물 1,000원")
        println("0. 처음으로")
    }
}
class Sides : Edible ("쿠키",1300) {
    override val category = mapOf("쿠키" to 1300, "감자칩" to 1300)
    override fun desc(){
        println("")
        println("---[사이드]---")
        println("1. 쿠키 1,300원")
        println("2. 감자칩 1,300원")
        println("0. 처음으로")
    }
    companion object {
        val cookies = setOf("더블 초코칩", "초코칩", "오트밀 레이즌", "라즈베리 치즈케익", "화이트 초코 마카다미아")
    }
}
fun main(){
    var receipt: Array<String> = arrayOf()
    var isBuying = true
    var price: Int = 0

    //class 불러오기
    val d = Descriptions()
    val sandwich = Sandwiches()
    val drink = Drinks()
    val side = Sides()
    while(isBuying) {
        //소개글 작성
        when (d.Intro()) {
            "0" -> break
            "-1" -> { isBuying = false; break }
            "1" -> { sandwich.desc(); sandwich.select()}
            "2" -> drink.desc()
            "3" -> side.desc()
        }
        d.More()
    }

    receipt.forEach { println(it) }
    descEnd(price)
    println(Sandwiches.breads)
}

