package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val start = System.currentTimeMillis()

    List(1000) {idx->launch {
        println("Coroutine $idx is running on thread ${Thread.currentThread().name}")
        delay(2000)
        println("Coroutine $idx has finished")
    }}.forEach { it.join() }

    val end = System.currentTimeMillis()
    println("end-start = ${end - start}")
}