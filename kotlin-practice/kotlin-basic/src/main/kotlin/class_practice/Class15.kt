package class_practice

interface Class15_1 {

}

interface Class15_2 {

}

interface Class15_3 : Class15_1, Class15_2 {}

class Class15_0 : Class15_3 {

}

fun main() {
    val a: Class15_1 = Class15_0()
    val b: Class15_2 = Class15_0()
    val c: Class15_3 = Class15_0()
    val d: Class15_0 = Class15_0()
}