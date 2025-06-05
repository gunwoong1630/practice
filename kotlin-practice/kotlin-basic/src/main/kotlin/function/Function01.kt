package function

fun main() {
    customFunction1()
    customFunction2(1, 2)
    println(customFunction3())

}

fun customFunction1() {
    println("customFunction1")
}

fun customFunction2(a: Int, b: Int) {
    println("a = ${a} b = ${b}")
}

fun customFunction3():String {
    return "Hello world"
}