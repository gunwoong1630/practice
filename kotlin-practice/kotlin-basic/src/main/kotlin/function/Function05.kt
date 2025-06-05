package function

fun main() {
    val p1 = fun(v: String) {
        println("v = ${v}")
    }

    p1("abc")

    val p2 = fun(v: String): String {
        return "pr $v"
    }

    println("p2(\"A\") = ${p2("A")}")

    fun hello() {
        println("hello")
    }

    hello()

    fun apply(fn: (Int) -> Int, number: Int): Int {
        return fn(number)
    }

    println("apply({ x -> x * x }, 10) = ${apply({ x -> x * x }, 10)}")

    fun apply2(number: Int, fn: (Int) -> Int): Int {
        return fn(number)
    }
    println("apply2(10){x-> x * x} = ${apply2(10) { x -> x * x }}")


    fun twoTimesAbs(x: Int): () -> Int {
        return {
            if (x > 0) x*2 else (x * -1) * 2
        }
    }

    val absV1 = twoTimesAbs(5)
    val absV2 = twoTimesAbs(-5)
    println(absV1 == absV2)
    println(absV1() == absV2())

    fun times(x: Int): (Int) -> Int {
        return {
            t -> x*t
        }
    }

    val fiveTimes = times(5)
    println(fiveTimes(3))





}
