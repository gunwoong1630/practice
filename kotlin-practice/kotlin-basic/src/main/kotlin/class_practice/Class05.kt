package class_practice

fun main() {
    val class051 = Class05_1()
    class051.printTemp()
    // Exception in thread "main" kotlin.UninitializedPropertyAccessException: lateinit property temp has not been initialized

    println("---")

    val class052 = Class05_2()
    println("class052.temp = ${class052.temp}")
    println("class052.temp = ${class052.temp}")

}

class Class05_1{
    lateinit var temp: String

    fun printTemp() {
        // this::temp.isInitialized
        if (::temp.isInitialized) {
            println("temp = ${temp}")
        } else {
            println("no temp")
        }
    }
}

class Class05_2{
    val temp: String by lazy {
        println("init temp")
        "hello"
    }
}