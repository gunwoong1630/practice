package class_practice

// 싱글톤 객체, 생성자 못씀
object Logger {
    fun log(msg: String) {
        println("Thread.currentThread().name +\" \" + msg = ${Thread.currentThread().name + " " + msg}")
    }
}

interface ClickListener {
    fun onClick()
}

fun handleClick(listener: ClickListener) {
    listener.onClick()
}

class Listener : ClickListener {
    override fun onClick() {}
}

class Game {
    companion object Settings {
        val diff = "H"
        fun printSettings() = println("difficulity = $diff")
    }

}

open class Class18(val name: String){
    open fun eat(sth: String) {
        println("Class18.eat")}
}

fun main() {
    Logger.log("hi")

    handleClick(object : ClickListener {
        override fun onClick() {
            println("<top>.onClick")
        }
    })

    Game.Settings.diff
    Game.Settings.printSettings()

    // when use companion
    Game.diff
    Game.printSettings()
}

class Class18Child2 : Class18("name") {
    override fun eat(sth: String) {
        println("Class18Child2.eat")
    }
}

fun Class18Child2.printName() = println(name) // extension function