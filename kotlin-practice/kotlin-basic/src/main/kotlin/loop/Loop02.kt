package loop

fun main() {
    val range1 = 1..10
    for (num in range1) {
        print("$num ")
    }
    println()

    for (num in 10 downTo 1) {
        print("$num ")
    }
    println()

    // odd
    for (num in 1..10 step 2) {
        print("$num ")
    }
    println()

    // even
    for (num in 2..10 step 2) {
        print("$num ")
    }
    println()

    for (num in 10 downTo 1 step 2) {
        print("$num ")
    }
    println()
}
