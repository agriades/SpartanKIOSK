package com.example.mykiosk
//샌드위치, 음료, 사이드 모두 먹을 수 있으므로 Edible이라는 부모 클래스의 자식으로 두어 볼까?
//https://www.subway.co.kr/menuList/sandwich
//샌드위치, 음료, 사이드에서 0 입력했을 때 ArrayIndexOutOfBoundsException
//그 외에도 List 사용해 바로 불러오므로, readln()으로 가져오는 String이 상상하지 못한 값일 때 예외 처리가 필요
open class Edible{
    open val category = listOf(listOf("상품명1", 100), listOf("상품명2", 200), listOf("상품명3", 300))
    open fun desc(){
        category.forEachIndexed{ index, menu ->
            println("${index+1}. ${menu[0]} - ${menu[1]}원")
        }
        println("0. 처음으로")
    }

    open fun addCart(): Pair<String, Int>{
        val index = (readln().toInt() - 1).toInt()
        val name = category[index][0]
        val price = category[index][1] as Int
        println("${name}을(를) 장바구니에 1개 추가했습니다.")
        val receiptLine: String = "${name} --- ${price}원"
        return Pair(receiptLine, price) //해당 상품의 가격 반환
    }

    fun hello(){
        println("===SpartanSUBWAY lv 4.==="); println("")
        println("안녕하세요! 서브웨이 내배캠 지점입니다. 원하는 메뉴를 선택하세요!")
        println("---[서브웨이 메뉴]---")
        println("1. 단품 샌드위치")
        println("2. 음료")
        println("3. 사이드")
        println("0. 종료")
    }

    fun helloAgain(){
        println("더 주문하고 싶으신가요?")
        println("---[서브웨이 메뉴]---")
        println("1. 단품 샌드위치")
        println("2. 음료")
        println("3. 사이드")
        println("0. 종료")
        println("-1. 결제하기")
    }

    fun payment(price: Int){
        println("${price}원을 결제합니다. Y/N")
        when(readln()){
            "Y", "y" -> println("결제가 완료되었습니다! 이용해주셔서 감사합니다.")
            "N", "n" -> println("결제를 취소합니다.")
        }
    }

    fun receipt(receiptLines: List<String>){
        println("---[영수증]---")
        receiptLines.forEach {println(it)}
    }
    fun bye(){
        println("===SpartanSUBWAY lv 3.===")
    }
}

class Sandwiches: Edible(){
    override val category = listOf(listOf("스파이시 쉬림프", 7900),
        listOf("에그마요", 5500), listOf("베지", 4900))
}

class Drinks: Edible(){
    override val category = listOf(listOf("탄산음료", 2000), listOf("물", 1000))
}

class Sides: Edible(){
    override val category = listOf(listOf("쿠키", 1300), listOf("감자칩", 1300))
}

fun main() {
    val subway = Edible()
    val sandwiches = Sandwiches()
    val drinks = Drinks()
    val sides = Sides()

    var isBuying = true
    var price: Int = 0
    var receiptLines = listOf<String>()

    subway.hello()
    while (isBuying) {
        when (readln()) {
            "1" -> {
                sandwiches.desc();
                val sandwich = sandwiches.addCart();
                receiptLines += sandwich.first; price += sandwich.second
            }

            "2" -> {
                drinks.desc();
                val drink = drinks.addCart();
                receiptLines += drink.first; price += drink.second
            }

            "3" -> {
                sides.desc();
                val side = sides.addCart();
                receiptLines += side.first; price += side.second
            }

            "0" -> {
                println("종료합니다."); break
            }

            "-1" -> {
                subway.payment(price); subway.receipt(receiptLines); break
            }
        }
        subway.helloAgain()
    }
}