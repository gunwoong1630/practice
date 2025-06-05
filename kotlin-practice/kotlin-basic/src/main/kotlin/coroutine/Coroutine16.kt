package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

val context = newSingleThreadContext("coroutineContext")
var contextCnt: Int = 0


suspend fun p2(action: suspend () -> Unit) {
    val i = 100
    val j = 100

    val time = measureTimeMillis {
        val services = List(i) {
            // globalscope는 스레드풀 사용함, 그렇다면 repeat될때마다 스레드가 배정되어 실행됨
            // 그럼으로 여러 스레드에서 동시에 실행되기 떄문에 value 동시성 문제 발생
            GlobalScope.launch {
                repeat(j) {
                    action()
                }
            }
        }
        services.forEach { it.join() }
    }
    println("time = ${time}")
}

fun main() = runBlocking {
    p2 {
        withContext(context) {
            contextCnt++
        }
    }
    println("contextCnt = ${contextCnt}")
}