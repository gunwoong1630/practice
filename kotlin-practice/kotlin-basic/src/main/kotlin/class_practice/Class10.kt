package class_practice

fun main() {
    val tmp1 = Class10_1()
    tmp1.sleep(1, "pizza")

}
open class Class10 {
    open fun sleep(hour: Int) {
        println("${hour}시간 잡니다")
    }
}


class Class10_1:Class10() {
    fun sleep(hour: Int,food:String) {
        println("$food 를 먹습니다")
        super.sleep(hour)
    }
}
