package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

var value: Int = 0
// 원자 변수 사용시 동시성 문제 해결
var atomic: AtomicInteger = AtomicInteger(0)

suspend fun p1(action: suspend () -> Unit) {
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
    p1 {
        value++
        atomic.incrementAndGet()
    }
    println("genericValue = ${value}")
    println("atomic = ${atomic}")
}