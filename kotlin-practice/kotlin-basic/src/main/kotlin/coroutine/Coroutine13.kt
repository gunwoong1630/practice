package coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
    launch {
        repeat(3) {
            println("A start")
            // 영역 양보, 값이 있을 경우 산출
            yield()
            println("A end")
        }
    }
    launch {
        repeat(3) {
            println("B start")
            yield()
            println("B end")
        }
    }
    launch {
        repeat(3) {
            println("C start")
            yield()
            println("C end")
        }
    }
}