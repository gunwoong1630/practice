package conditional_statements

fun main() {
    val level: Int = 10

    // 1. 값 넣기
    when (level) {
        1 -> println("platinum")
        2 -> println("gold")
        3 -> println("silver")
        4 -> println("bronze")
        else -> println("nothing")
    }

    // 2. 조건 넣기
    when {
        level == 1 -> println("platinum")
        level == 2 -> println("gold")
        level == 3 -> println("silver")
        level == 4 -> println("bronze")
        else -> println("nothing")
    }

    val result = when (level) {
        1 -> "platinum"
        2 -> "gold"
        3 -> "silver"
        4 -> "bronze"
        else -> "nothing"
    }
    println("result = ${result}")

    val result2: String? = when (level) {
        1 -> {
            println("플래티넘 달성")
            "platinum"
        }
        2 -> "gold"
        3 -> "silver"
        4 -> "bronze"
        else -> "nothing"
    }
}
