package conditional_statements

fun main() {
    val score: Int = 85

    val result = if (score > 89) {
        "A"
    } else if (score > 79) {
        "B"
    } else {
        "C"
    }

    println("result = ${result}")

    val result2 = if (score > 89) 'A' else if (score > 79) 'B' else 'C'
    println("result2 = ${result2}")

    val result3: String = if (score > 89) {
        println("A로 합격")
        "A"
    } else if (score > 79) {
        println("B로 합격")
        "B"
    } else {
        println("C로 합격")
        "C"
    }

    println("XXX")
    println("result3 = ${result3}")

}
