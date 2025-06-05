package class_practice

fun main() {
    val parent = Parent()
    println("parent.name = ${parent.name}")
    val child = Child()
    println("child.name = ${child.name}")
    val child2 = Child2()
    child2.bar()

}


open class Parent {
    private val secretName: String = "private name"
    open var name: String = "name"
    
    open fun foo() {
        println("Parent foo")
    }

    open fun bar() {
        println("Parent bar")
    }
}

class Child : Parent() {
    override var name: String = "child name"
    
    override fun foo() {
        println("Child foo")
    }

    override fun bar() {
        println("Child bar")
    }
}


open class Child2 : Parent() {
    override fun bar() {
        println("Child2.bar")
    }
}