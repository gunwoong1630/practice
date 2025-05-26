package loop

var k = 1

fun main() {
    var i = 1
    do {
        print("$i ")
        i += 2
    } while (i < 10)
    println()

    do processDoWhile() while (k < 10)

    val value = 7
    for (num in 1..9) {
        println("$value X $num = ${value * num}")
    }
    val a = 7
    var b = 1
    do println("$a X $b = ${a * b}") while (++b < 10)

    repeat(5) {
        println("*".repeat(5))
    }
}


fun processDoWhile() {
    k *= 2
    print("* ")
}
