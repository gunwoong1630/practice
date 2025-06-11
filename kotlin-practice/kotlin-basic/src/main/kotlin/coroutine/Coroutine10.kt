package coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val asyncValue = async {
        delay(5000)
        "Async task completed"
    }
    println("asyncValue = ${asyncValue}")
    println("asyncValue = ${asyncValue.await()}")
}