package function

var cnt = 0

fun main() {
    println("cnt = ${cnt}")
    println(power(3))
    println(power(4))
    println(power(5))
    println(power(6))

    println("cnt = ${cnt}")
    println(increaseCnt())
    println(increaseCnt())
    println(increaseCnt())
    println("cnt = ${cnt}")

    // 익명 함수
    fun() {
        println("fun")
    }

    // 익명함수
    val sayHello = fun() {
        println("sayHello")
    }

    println("sayHello = ${sayHello}")
    sayHello()

    // 람다 표현식
    val sayBye: () -> Unit = { println("sayBye") }
    println("sayBye = ${sayBye}")
    sayBye()

    val sum1 = { a: Int, b: Int -> a + b }
    val sum2: (Int, Int) -> Int = { a, b -> a + b }
    val sum3: (Int, Int) -> Int = { a, b ->
        println("empty space")
        a + b
    }
    println("sum1(1,2) = ${sum1(1, 2)}")
    println("sum2(1,2) = ${sum2(1, 2)}")
    println("sum3(1,2) = ${sum3(1, 2)}")

    // 람다 표현식에서 return은 그냥은 못쓰고 label을 활용해야 쓸수있음
    val ap:(Int,Int) -> Int = ap@{x,y->
        if (x > y) {
            return@ap x
        }
        x + y
    }
    println("ap(1,3) = ${ap(1, 3)}")
    println("ap(3,1) = ${ap(3, 1)}")

}

// 순수함수
fun power(x: Int): Int {
    return x * x;
}

// 비순수 함수
fun increaseCnt(): Int {
    cnt++
    return cnt
}