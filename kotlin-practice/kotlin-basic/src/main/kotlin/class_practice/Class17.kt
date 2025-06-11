package class_practice

data class Class17(var name: String, val code: String)

data class Class17Info(var name: String, var grade: String){
    init {
    }
}


fun main() {
    val a = Class17("a", "b")
    val b = Class17("c", "d")
    println(a == b)
    println(a === b)

    println("a.hashCode() = ${a.hashCode()}")
    println("b.hashCode() = ${b.hashCode()}")


}

