package class_practice

fun main() {
    val c1 = Class14_1()
    val c2 = Class14_2()
    c2.print()
}

class Class14_1: Class14A
class Class14_2 : Class14A, Class14B {
    override fun print() {
        super<Class14B>.print()
        println("Class14_2.print")
    }
}


interface Class14A {
    fun print(){
        println("Class14A <UNK>")
    }
}

interface Class14B {
    fun print(){
        println("Class14B <UNK>")
    }
}