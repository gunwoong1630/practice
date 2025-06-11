package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

fun main() {
    val threadPool = Executors.newFixedThreadPool(1)

    println("Thread.currentThread().name = ${Thread.currentThread().name}")

    threadPool.submit {
        println("[1] Thread.currentThread().name = ${Thread.currentThread().name}")

        GlobalScope.launch {
            println("[2] GlobalScope.launch Thread.currentThread().name = ${Thread.currentThread().name}")
            repeat(3) {
                delay(500)
                println("[3] After delay in GlobalScope.launch Thread.currentThread().name = ${it}")
            }
            println("[4] End of GlobalScope.launch Thread.currentThread().name = ${Thread.currentThread().name}")
        }
        println("[5] After GlobalScope.launch Thread.currentThread().name = ${Thread.currentThread().name}")
    }

    Thread.sleep(2000)

    threadPool.shutdown()
    while (!threadPool.isTerminated) {
        Thread.sleep(100)
    }
}
