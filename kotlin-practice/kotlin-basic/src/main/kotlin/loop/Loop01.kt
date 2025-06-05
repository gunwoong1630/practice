package loop

import org.w3c.dom.ranges.Range

fun main() {

    var cnt: Int = 0

    while (cnt <= 10) {
        print(cnt)
        cnt++
    }

    // .. 연산자
    var range1 = 1..5
    getRangeNumbers(range1)

    val range2 = 1L..5L
    getRangeNumbers(range2)

    val range3 = 'a'..'e'
    getRangeNumbers(range3)

    // 문자열 range는 in만 가능, iterable X
    val range4 = "aaa".."ddd"
    println("range4 = ${range4}")

    // 역방향
    val range5 = 5 downTo 1
    getRangeNumbers(range5)

    // 범위 간격 조절
    val range6 = 1..10 step 2
    getRangeNumbers(range6)

    val range7 = 10 downTo 1 step 3
    getRangeNumbers(range7)

    // 열린 범위 연산자(끝 값을 뺌)
    val range8 = 0 until 5
    getRangeNumbers(range8)

    // in
    val s1 = 1..10 step 2
    val t1 = 3
    println("t1 in s1 = ${t1 in s1}")
    println("t1 !in s1 = ${t1 !in s1}")

    // 범위에 포함되는가
    val c1 = 1..5
    val c2 = 2..4
    println("c1 in c2 = ${c1.first in c2 && c1.last in c2}")
    println("c2 in c1 = ${c2.first in c1 && c2.last in c1}")
    println("c1 in c2 = ${c1.isWithin(c2)}")
    println("c2 in c1 = ${c2.isWithin(c1)}")


}

fun <T> getRangeNumbers(range: Iterable<T>) {
    for (i in range) {
        print("$i ")
    }
    println()
}

// 확장 함수
fun IntRange.isWithin(outer: IntRange): Boolean {
    return this.first in outer && this.last in outer
}

