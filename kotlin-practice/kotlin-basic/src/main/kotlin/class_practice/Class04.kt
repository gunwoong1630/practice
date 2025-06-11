package class_practice

fun main() {
    val m1 = MemberV1("a", 1)
    println("m1.name = ${m1.name}")

    m1.name = "John"
    println("m1.name = ${m1.name}")

    val m2 = MemberV2("b", 2)
    println("m2.name = ${m2.name}")

    val m3 = MemberV3("c", 3, -3)
    println("m3.grade = ${m3.grade}")
//    m2.name = "John"
//    println("m2.name = ${m2.name}")
}

class MemberV1(var name: String, var age: Int) {
//    fun getName(): String {
//        return name
//    }
}

class MemberV2(val name: String, val age: Int) {}
class MemberV3(val name: String, val age: Int,grade: Int) {
    var grade: Int = grade
        get() {
            return if (field > 0) field else 0
        }
    set(value) {
        field = value
    }
}


