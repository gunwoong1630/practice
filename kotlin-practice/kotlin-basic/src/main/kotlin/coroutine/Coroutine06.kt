package coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("[1]")
    runBlocking {
        launch {
            println("[2]")
            println("this.coroutineContext = ${this.coroutineContext}")
            println("Thread.currentThread().name = ${Thread.currentThread().name}")
        }
    }
    println("[3]")

}