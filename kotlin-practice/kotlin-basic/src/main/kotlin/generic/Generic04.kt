package generic

class Generic04 {
    interface ComponentA
    interface ComponentB

    open class ComponentA_1: ComponentA
    open class ComponentB_1: ComponentB
    open class ComponentC: ComponentA, ComponentB

    class ComponentD: ComponentA_1(), ComponentB

    fun <T> test1(target:T) where T: ComponentA, T: ComponentB {
        println("test1: $target")
    }
    fun <T> test2(target:T) where T: ComponentB, T: ComponentB_1 {
        println("test2: $target")
    }
}

fun main() {
    val generic04 = Generic04()
    val componentC = Generic04.ComponentC()
    val componentD = Generic04.ComponentD()

    generic04.test1(Generic04.ComponentC())

}