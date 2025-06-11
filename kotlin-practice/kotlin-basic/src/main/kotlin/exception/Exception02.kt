package exception

class CustomExcpetion(msg: String): Exception(msg)

fun main() {
    runCatching {
        throw CustomExcpetion("Custom exception message")
    }.onFailure {
        println("Caught exception: ${it::class.simpleName}")
    }.onSuccess {
        println("No exception thrown") }
}