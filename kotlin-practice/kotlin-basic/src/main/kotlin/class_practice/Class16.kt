package class_practice

class CompanionExample {
    companion object {
        fun fly() {
            println("Class16.fly")
        }

        @JvmStatic
        fun flyStatic() {
            println("Class16.flyStatic")
        }
    }
}

fun main() {
    CompanionExample.fly()

}