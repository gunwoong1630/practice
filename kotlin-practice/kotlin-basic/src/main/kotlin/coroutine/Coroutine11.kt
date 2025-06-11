package coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun fetchData(): String {
    delay(1000L)
    // dely는 루틴 환경에서만 사용 가능
    println("received data")
    return "received data"
}

fun main() = runBlocking<Unit> {
    // 동기
    println("fetchData() = ${fetchData()}")

    // 비동기, 왜냐하면 async를 사용했기 때문
    val result = async { fetchData() }

    launch {
        repeat(5) { i ->
            delay(500L)
            println("Coroutine is running: $i")
        }
    }
    println("received")
    println("result.await() = ${result.await()}")
}