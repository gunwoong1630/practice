package org.example.operator
data class Box(val name: String)

fun main() {
    val a = 10
    val b = 10
    val c = a
    val d = a


    val cRefNEqd = c !== d
    println("cRefNEqd = ${cRefNEqd}")

    val box1:Box = Box("A")
    val box2:Box = Box("A")
    val box3:Box = box1


}
