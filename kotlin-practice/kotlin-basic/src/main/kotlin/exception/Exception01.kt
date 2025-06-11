package exception

fun main() {
    try {
        throw IllegalArgumentException("Invalid argument provided")
    } catch (e: IllegalArgumentException) {
        println("Caught an IllegalArgumentException: ${e.message}")
    } catch (e: Exception) {
        println("Caught a general exception: ${e.message}")
    } finally {
        println("This block always executes, regardless of exceptions.")
    }

    val result = runCatching {
        10 / 0
    }

    result.onSuccess {
        println("success: $it")
    }.onFailure {
        println("failure: ${it.message}")
    }

    runCatching { 10 / 2 }.onSuccess {
        println("it = ${it}")
    }.onFailure {
        println("it.message = ${it.message}")
    }

    runCatching {
        ExceptionFactory().make(2000)
    }.onSuccess {
        println("Components created successfully.")
        it.activateComponent()
    }.onFailure {
        println("Failed to create components: ${it.message}")
    }.also {
        if (it.isFailure) {
            println("An error occurred while creating components.")
        }
    }
}

class ExceptionFactory {
    fun make(mat:Int=10): Exception1{
        return assemble(makeComponents(mat))
    }

    private fun assemble(components:List<String>): Exception1 {
        return Exception1(components)
    }

    private fun makeComponents(mat: Int): List<String> {
        var remian = mat
        println("remian = ${remian} 만큼 이용하여 컴포넌트를 만듭니다.")

        remian -= (1..10).random()
        if (remian < 1) {
            throw  IllegalArgumentException("<UNK> <UNK> <UNK> <UNK>.")
        }
        remian -= (1..10).random()
        if (remian < 1) {
            throw  IllegalArgumentException("<UNK> <UNK> <UNK> <UNK>.")
        }

        remian -= (1..10).random()
        if (remian < 1) {
            throw  IllegalArgumentException("<UNK> <UNK> <UNK> <UNK>.")
        }
        return listOf("Component A", "Component B", "Component C")
    }
}

class Exception1(val components:List<String>) {
    fun activateComponent() {
        for (component in components) {
            println("component = ${component}")
        }
    }
}
