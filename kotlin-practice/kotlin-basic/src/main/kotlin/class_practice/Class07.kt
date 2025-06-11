package class_practice

fun main() {

    val animal = Animal("cat")
    animal.cry()
    animal.play().invoke()

    val dog = Dog("Rex")
    println("dog.name = ${dog.name}")
    dog.cry()
    dog.play().invoke()


}

open class Animal(val name: String){
    open fun cry() = println("Animal cry")
    open fun play():()-> Unit = {
        println("Animal play")
        println("Animal play")
    }
}

open class Dog(name: String): Animal(name)

class Cat : Animal {
    constructor() : super(name = "nabi")
}

class Husk(name: String) : Dog(name) {
    override fun cry() {
        super.cry()
    }

    override fun play(): () -> Unit {
        return super.play()
    }
}