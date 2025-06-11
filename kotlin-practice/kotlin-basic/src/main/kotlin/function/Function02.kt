package function

import kotlin.math.log

fun main() {
//    say1()
    say1("minsu")
    say2()
    say2("gunwoong")

    orderCoffee("americano", "tall", true)
    orderCoffee("latte", "small", false)
    orderCoffee(size = "tall", name = "soda", isIce = false)

    printCartList(5, "a", "b", "c", "d", "e", "f", "g")
    val cartList = arrayOf("a", "b", "c", "d", "e", "f", "g")
    printCartList(7, *cartList)

    logging(messages = arrayOf("log1", "log2", "log3"))
    logging("FATAL", "오류1", "오류2", "오류3")
}

fun say1(word: String) {
    println("word = ${word}")
}

fun say2(word: String = "minsu") {
    println("word = ${word}")
}

fun orderCoffee(name: String, size: String, isIce: Boolean) {
    println("name = [${name}], size = [${size}], isIce = [${if (isIce) "아이스" else "핫"}]")
}

// 가변인자
fun printCartList(size: Int, vararg items: String) {
    println("size = [${size}], items = [${items.joinToString(", ")}]")
}

fun logging(type: String = "INFO", vararg messages: String) {
    for (message in messages) {
        println("message = ${message}")
    }
}