package typecast

fun main() {
    // 스마트 캐스트
//    var value = 10.0
    var value:Number = 10.0
    println("value = ${value}")
    println("value type = ${value::class.simpleName}")

    value = 10
    println("value = ${value}")
    println("value type = ${value::class.simpleName}")

    value = 10L
    println("value = ${value}")
    println("value type = ${value::class.simpleName}")



}
