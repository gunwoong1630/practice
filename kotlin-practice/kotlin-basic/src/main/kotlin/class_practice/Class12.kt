package class_practice

fun main() {
    val c = Class12("minsu")
    c.eatOrigin("pizza")
    c.eat("pizza")

    c eat "pizza"
    c.printName()
}

class Class12(val name: String) {
    fun printName() {
        println("name = ${name}이/가 먹습니다")
    }
    fun eatOrigin(sth: String) {
        println("sth = ${sth}")
    }

    infix fun eat(sth: String) {
        println("sth = ${sth}")
    }

}