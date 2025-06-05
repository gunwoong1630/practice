package class_practice

fun main() {
//    Class11()
    val tmp = Class11_1()
    tmp.f1()
    tmp.f2()
    println()
    tmp.af1()

    println("---")

    val classes = listOf<Class11_2>(Class11_3(), Class11_4())
    for (tmp in classes) {
        tmp.f1()
        tmp.f2()
        tmp.f1(1)
        tmp.f2()
    }
}

abstract class Class11 {
    abstract fun af1()
    fun f1() {
        println("Class11.f1")
    }
    open fun f2() {
        println("Class11.f2")
    }
}

class Class11_1 : Class11() {
    override fun af1() {
        println("Class11_1.af1")
    }

    override fun f2() {
        println("Class11_2.af2")
        super.f2()
    }
}

abstract class Class11_2 : Class11() {
    abstract fun f1(a: Int)
    open fun f2(a: Int) {
        println("Class11_2.f2")
    }
}

class Class11_3 : Class11_2() {
    override fun f1(a: Int) {
        println("Class11_3.f1")
    }

    override fun f2(a: Int) {
        println("Class11_3.f2")
        super.f2(a)
    }

    override fun f2() {
        println("Class11_3.f2")
        super.f2()
    }

    override fun af1() {
        println("Class11_3.af1")
    }
}

class Class11_4 : Class11_2() {
    override fun f1(a: Int) {
        println("Class11_4.f1")
    }

    override fun f2(a: Int) {
        println("Class11_4.f2")
        super.f2(a)
    }

    override fun f2() {
        println("Class11_4.f2")
        super.f2()
    }

    override fun af1() {
        println("Class11_4.af1")
    }
}