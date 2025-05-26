package loop

fun main() {
    first@ for (i in 1..3) {

        for (j in 1..3) {
            if (j == 2) {
                break@first
            }
            println("i = $i j = $j")
        }
    }

    val board = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),
    )

    val target = 5

    search@for (i in board.indices) {
        for (j in board[i].indices) {
            println("[$i][$j] == ${board[i][j]}")
            if (board[i][j] == target) {
                println("타겟 발견")
                break@search
            }
        }
    }

    for (i in 1..5) {
        if (i == 2) {
            continue
        }
        print("$i ")
    }
    println()

    point@for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) {
                continue@point
            }
            println("i = $i j = $j")
        }
    }

    val map = arrayOf(
        arrayOf("O", "X", "O", "O"),
        arrayOf("O","O","T","O"),
        arrayOf("O","X","X","X"),
    )


    outer@for (i in map.indices) {
        for (j in map[i].indices) {
            val land = map[i][j]
            when (land) {
                "X" -> {
                    println("X를 만나서 건너 뛰겠습니다")
                    continue@outer
                }

                "T" -> {
                    println("$i $j 에서 T를 찾았습니다")
                    break@outer
                }

                else -> {
                    println("탐색중")
                }
            }
        }
    }
}
