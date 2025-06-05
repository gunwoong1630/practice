package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
//        delay(2000)
        // This is a coroutine running in the GlobalScope
        println("Thread.currentThread().name = ${Thread.currentThread().name}")
        println("this.coroutineContext = ${this.coroutineContext}")
    }

    // Keep the main thread alive for a while to see the coroutine output
    Thread.sleep(1000) // Sleep for 1 second
    println("Main thread is finishing.")
}
