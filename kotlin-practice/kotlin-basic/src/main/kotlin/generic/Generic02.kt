package generic

fun main() {
    val a: List<Int> = listOf(1, 2, 3)

    val b: MutableList<Int> = mutableListOf(1)
    b.add(2)

    val c: List<Int> = mutableListOf(1, 2, 3)
//    val d: MutableList<Int> = listOf(1, 2, 3)

    printCollections(a)
    checkType(a)
}

fun <T> printCollections(list: List<T>) {
    for (item in list) {
        println(item)
    }
}

fun <T> checkType(param: T) {
    if (param is List<*>) {
        println("param = ${param}")
    }
}