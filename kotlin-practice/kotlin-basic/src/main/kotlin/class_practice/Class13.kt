package class_practice

fun main() {
    val c1: Class13 = Class13_1()
    c1.a()
    c1.b()
    c1.c()

    val c2: Class13_1 = Class13_1()
    c1.a()
    c1.b()
    c1.c()
}

interface Class13 {
    public abstract fun a()
    fun b()
    fun c(){}
}

class Class13_1 : Class13 {
    override fun a() {
        TODO("Not yet implemented")
    }

    override fun b() {
        TODO("Not yet implemented")
    }

    override fun c() {
        super.c()
    }
}