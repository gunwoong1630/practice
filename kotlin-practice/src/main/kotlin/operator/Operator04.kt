package org.example.operator

fun main() {
    // 안전 호출 연산자
    // Safe Call Operator
    // ?.

    val s1: String = "Hello, world"
    val result1 = s1.length
    println("result1 = ${result1}")

//    val s2: String? = "Hello, world"
//    val result2 = s2.length
    // activate Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?

    val s2: String? = "Hello, world"
    val result2: Int? = s2?.length
    println("result2 = ${result2}")

    val s3: String? = null
    val result3: Int? = s3?.length
    println("result3 = ${result3}")

    // 엘비스 연산자
    // Elvis Operator
    // ?:
    // 이항 연산자, 좌측값이 null일 경우 오른쪽값 리턴
    val s4: String? = "Hello, world"
    val result4 = s4 ?: "Bye"
    println("result4 = ${result4}")

    val s5: String? = null
    val result5 = s5 ?: "Bye"
    println("result5 = ${result5}")

//    val s6: String? = null
    val s6: String = "Hello, world"
    val result6 = s6!!.length



}
