package function

fun main() {
    orderCoffee()
    val minsu = Human()
    minsu eat "hambugar"

}

class Human {
    infix fun eat(sth: String) {
        println("eat $sth")
    }
}

// overloading
fun orderCoffee() {
    println("<top>.orderCoffee")
}

fun orderCoffee(type: String) {
    println("<top>.orderCoffee $type")
}

fun orderCoffee(type: String, size: String) {
    println("type = ${type}")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

//fun sum(a: Int, b: Int): Int {
//    return 0
//}

fun sum(a: Double, b: Int): Int {
    return 0
}

fun sum(a: Int, b: Int, c: Int): Int {
    return a + b + c
}