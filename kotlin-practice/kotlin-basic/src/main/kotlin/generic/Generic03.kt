package generic

fun main() {
    val tmp = listOf(Generic03_1(), Generic03_2())

    activate(tmp, "pizza")

    println("customSum(1, 2) { a, b -> a + b } = ${customSum(1, 2) { a, b -> a + b }}")
    println("customSum(1, 2) { a, b -> a + b } = ${customSum("1", "2") { a, b -> a + b }}")
}

open class Generic03(val sth: String) {
    fun activate(sth: String): Unit {
        println("sth = ${sth}")
    }
}

class Generic03_1 : Generic03("dog")
class Generic03_2 : Generic03("cat")

fun <T : Generic03> activate(target: List<T>, sth: String): Unit {
    for (generic03 in target) {
        generic03.activate(sth)
    }
}

fun <T> customSum(a: T, b: T, operation: (T, T) -> T): T {
    return operation(a, b)
}