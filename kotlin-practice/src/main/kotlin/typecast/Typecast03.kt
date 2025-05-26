package typecast

fun main() {

    // as, 명시적 형변환
    val target1: Any = "Hello world"
    val strTarget: String = target1 as String
    println("strTarget = ${strTarget}")
    try {
        val intTarget = target1 as Int
    } catch (e: ClassCastException) {
        println("문자열을 숫자로 캐스팅 못함 (명시적 형변환 문제점)")
    }

    val target2: Any = 100
    val strTarget2: String? = target2 as? String
    println("strTarget2 = ${strTarget2}")

    val itemList: List<Any> = listOf("mango", 100, 'c', true, 10.0, 10L,"grape")
    printStr(itemList)
}

fun printStr(target: List<Any>) {
    for (i in target) {
        val iStr = i as? String
        if (iStr != null) {
            print("$iStr ")
        }
    }
}
