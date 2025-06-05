package coroutine

import java.util.concurrent.Executors

fun main() {
    val threadPool = Executors.newFixedThreadPool(5)

    val start = System.currentTimeMillis()


    List(100) { idx ->
        {
            println("ThreadPool start ${Thread.currentThread().name} is running task $idx")
            Thread.sleep(2000)
            println("ThreadPool end ${Thread.currentThread().name} is running task $idx")
        }
    }.forEach { task ->
        threadPool.submit(task)
    }

    threadPool.shutdown()
    while (!threadPool.isTerminated) {
        // Wait for all tasks to finish
        Thread.sleep(100)
    }

    val end = System.currentTimeMillis()
    println(end - start)



}