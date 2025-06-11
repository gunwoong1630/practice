package function

fun main() {
    _sayName("minsu")
    println()

    func1({ println("hello world") })
    println()

    // 트레일링 람다 문법 = 마지막 인자가 람다식일때 괄호 밖으로 뺴기 가능
    func1 { println("hello world") }
    println()

    func1(){ println("hello world")}
    println()

    func1_1("TAG"){ println("hello world") }
    println()

//    func1_2("TAG", "NAME"){ println("helo")}
    func1_2("TAG", { println("hello world") }, "NAME")
    println()

    func2(10,{ println("$it")})
    // 람다 표현식은 객체를 만들어서 오버헤드 발생 가능, inline은 객체를 만들지 않아 유리하긴 하나 바이트코드가 불필요하게 커질수 있음

    placeBookOrder(3) { println("it = ${it}")}
}

fun _sayName(name: String) {
    println("name = ${name}")
}

fun func1(fn: () -> Unit) {
    println("func1 start")
    fn()
    println("func1 end")
}

fun func1_1(tag: String, fn: () -> Unit) {
    println("tag = ${tag}")
    fn()
}

fun func1_2(tag: String, fn: () -> Unit,name: String) {
    println("tag = ${tag}")
    fn()
    println("name = ${name}")
}

inline fun func2(number: Int, fn: (Int) -> Unit) {
    println("func2 start")
    fn(number)
    println("func2 end")
}

inline fun placeBookOrder(quantity: Int, order: (Int) -> Unit) {
    println("quantity = ${quantity}")
    order(quantity)
}