package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    // sequence 안은 동기처럼 작동
    val numbers = sequence {
        println("[1] before yield")
        yield(1)
        println("[1] after yield")

        println("[2] before yield")
        yield(2)
        println("[2] after yield")

        println("[3] before yield")
        yield(3)
        println("[3] after yield")
    }
    launch {
        for (number in numbers) {
            println(number)
            delay(500L)
        }

    }
}