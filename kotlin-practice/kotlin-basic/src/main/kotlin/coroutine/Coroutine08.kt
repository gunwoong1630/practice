package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val result = GlobalScope.launch {
        delay(1000)
        println("World!")
    }

    println("Hello,")
    println("result.isActive = ${result.isActive} ${result.isCompleted}")
    Thread.sleep(1000)
    println("result.isActive = ${result.isActive} ${result.isCompleted}")
}