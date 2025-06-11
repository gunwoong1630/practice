package coroutine

fun main() {
    @Synchronized
    {}

    val v1 = Any()
    synchronized(v1) {

    }
}

@Synchronized
fun syncFunc() {
    println("${Thread.currentThread().name}")
}