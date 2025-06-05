package typecast

val INTEGER_VALUE: Int = 10

fun main() {
    // is
    val isResult: Boolean = INTEGER_VALUE is Int
    println("isResult = ${isResult}")

    val s1: String = "Hello, world"
    val s2: String? = "Bye!"

    printLength(s1)
    printLength(s2)
    printLength(1)

    isNotInteger(s1)
    isNotInteger(1)


}

fun printLength(target: Any?) {
    if (target is String) {
        // target이 is문이 실행될때 String으로 스마트 캐스트 발동
        println("target.length = ${target.length}")
    } else {
        println("문자열 아님")
    }
}

fun isNotInteger(target: Any?) {
    // 스마트 캐스트 발동
    if (target !is Int) {
        println("정수가 아님")
        return
    }
    println("정수입니다")
    println("target::class.simpleName = ${target::class.simpleName}")
}
