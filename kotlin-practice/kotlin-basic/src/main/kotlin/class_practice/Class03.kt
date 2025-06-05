package class_practice

fun main() {
    println("PUBLIC_VALUE = ${PUBLIC_VALUE}")
    println("INTERNAL_VALUE = ${INTERNAL_VALUE}")

    val publicClass = PublicClass()
    val internalClass = InternalClass()

    val openedClass = OpenedClass()
    openedClass.publicFunction()
    openedClass.internalFunction() // 모듈은 클래스나 함수 단위가 아님
}