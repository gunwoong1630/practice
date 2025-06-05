package class_practice

fun main() {
    val sentence = "Hello, Kotlin World!"

    sentence.printUppercase()
    "Hello, Kotlin World!".printUppercase()

    val class09 = Class09("shirt", "large")
    class09.print()
    class09.printExtend()

}

fun String.printUppercase() {
    println(this.uppercase())
}

class Class09(var type: String,var size: String){
    fun print()  = when (type) {
        "shirt" -> println("This is a $size shirt")
        "pants" -> println("These are $size pants")
        else -> println("Unknown type")
    }
}

fun Class09.printExtend() {
    when (type) {
        "shirt" -> println("This is a $size shirt")
        "pants" -> println("These are $size pants")
        else -> println("Unknown type")
    }
}