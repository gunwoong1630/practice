package class_practice

public val PUBLIC_VALUE: String = "PUBLIC"
internal val INTERNAL_VALUE: String = "INTERNAL"
private val PRIVATE_VALUE: String = "PRIVATE"

public fun publicFunction(): Unit {
    println("publicFunction")
}
internal fun internalFunction(): Unit {
    println("internalFunction")
}
private fun privateFunction(): Unit {
    println("privateFunction")
}

public class PublicClass {}
internal class InternalClass {}
private class PrivateClass {}

open class OpenedClass {
    public fun publicFunction(): Unit {
        println("publicFunction")
    }
    internal fun internalFunction(): Unit {
        println("internalFunction")
    }
    private fun privateFunction(): Unit {
        println("privateFunction")
    }
    protected fun protectedFunction(): Unit {
        println("protectedFunction")
    }
}

class ChildClass : OpenedClass() {
    fun callTest() {
        println("ChildClass.callTest")
        publicFunction()
        internalFunction()
        privateFunction()
        protectedFunction()
    }
}

class VisibilityModifier {
}

fun main() {
    println("PUBLIC_VALUE = ${PUBLIC_VALUE}")
    println("INTERNAL_VALUE = ${INTERNAL_VALUE}")
    println("PRIVATE_VALUE = ${PRIVATE_VALUE}")

    publicFunction()
    internalFunction()
    privateFunction()

    PublicClass()
    InternalClass()
    PrivateClass()

    val oc: OpenedClass = OpenedClass()
    oc.publicFunction()
    oc.internalFunction()
//    oc.protectedFunction()
//    oc.privateFunction()
    println()
    val cc: ChildClass= ChildClass()
    cc.callTest()
}