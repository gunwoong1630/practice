package generic

fun main() {
    f1(100)
    runCatching { f1("100") }.onFailure {
        println("Caught an exception: ${it.message}")
    }

    f2(100)
    f2<String>("Hello")

    val tmp1 = Generic01("A")
    val tmp2: Generic01<String> = Generic01("A")

    val tmp21 = tmp1.tmp2(10)

}

fun f1(param: Any) {
//    val result = param - 100
    val result = param as Int - 100
    println("result = ${result}")
}

fun <T> f2(param: T) { // Any?
    println("param.javaClass.simpleName = ${param!!.javaClass.simpleName}")
}

class Generic01<T>(val value: T) {
    fun get(): T? {
        return if (value != null) value else throw NoSuchElementException()
    }

    fun <N> tmp2(param:N): T?{
        println("param = ${param}")
        println("param.javaClass.simpleName = ${param!!.javaClass.simpleName}")
        return get()
    }
}