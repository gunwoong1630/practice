package coroutine

import kotlin.concurrent.thread

class CoroutineThread : Thread() {
    override fun run() {
        println("Coroutine thread is running ${Thread.currentThread().name}")
    }
}

class CoroutineThread2 : Runnable {
    override fun run() {
        println("Coroutine thread 2 is running ${Thread.currentThread().name}")
    }
}

fun main() {
    println("Thread.currentThread() = ${Thread.currentThread().name}")

    val thread1 = CoroutineThread()
    thread1.start()

    val thread2 = Thread(CoroutineThread2())
    thread2.start()

    Thread{ println("Thread is running ${thread1.name}") }.start()

    val thread4 = object : Thread(){
        override fun run() {
            println("Thread 4 is running ${Thread.currentThread().name}")
        }
    }
    thread4.start()

    thread(start = false, name = "nabi") {
        println("Thread nabi is running ${Thread.currentThread().name}")
    }.start()

}