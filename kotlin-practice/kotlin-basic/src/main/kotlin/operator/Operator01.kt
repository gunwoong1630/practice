package org.example.operator

fun main() {
//    val pmA: Int = 10
    val pmA = 10
    val pmB = 5

//    선언시 아래와 같이 자료형까지 선언해줘야
//    val pmB
//    pmB = 10
//    pmB = "10"

    val sumResult = pmA + pmB
//    val sumResult:Int = pmA + pmB

    println("pmA = ${pmA}")

    val divA = 10
    val divB = 3

    val divResult1 = divA / divB
    println("divResult1 = ${divResult1}")


    val divResult2 = divA.toDouble() / divB
    println("divResult2 = ${divResult2}")

    var q1 = 5
    println("q1 = ${++q1 * 3}")

}
