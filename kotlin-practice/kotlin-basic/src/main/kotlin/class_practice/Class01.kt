package class_practice

class A constructor(name: String, size: Int, flag: Boolean) {
    val name = name
    val size = size
    val flag = flag

    fun intro() {
        println("name = ${name}")
    }
}

class AA constructor(
    val name: String,
    val size: Int,
    val flag: Boolean
) {

    fun intro() {
        println("name = ${name}")
    }
}

class B(
    val name: String,
    val size: Int,
    val flag: Boolean
) {

}

class C {
    val name: String
    val size: Int
    val flag: Boolean

    constructor() {
        this.name = "a"
        this.size = 0
        this.flag = false
    }

    constructor(name: String, size: Int, flag: Boolean) {
        this.name = name
        this.size = size
        this.flag = flag
    }
}

class D(name: String) {
    val name = name
    var size: Int = 0
    var flag: Boolean = false

    constructor(name: String, size: Int, flag: Boolean) :this(name){
        this.size = size
        this.flag = flag
    }
}

class E1(var name: String, var size: Int, var flag: Boolean) {
    var price = 0

    init {
        name = when (name) {
            "T" -> "Tall"
            "G" -> "Grande"
            else -> "EMPTY"
        }

    }

}

class E2(var name: String, var size: String, var price: Int) {
    init {
        if (size !in arrayOf("T", "G", "M")) {
            size = "EMPTY"
        }

    }
}

class E3(var name: String, var size: String) {
    var price = 0

    init {
        println(1)
    }

    init {
        println(2)
    }
    init {
        println(3)
    }
}


fun main() {
    println("E3(\"a\",\"b\") = ${E3("a", "b")}")
}