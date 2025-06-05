package coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val result1: Job = launch {
        delay(500)
        println("Task 1 completed")
    }
    val result2: Job = launch {
        delay(2500)
        println("Task 2 completed")
    }
}