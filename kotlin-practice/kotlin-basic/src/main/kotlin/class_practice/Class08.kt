package class_practice

fun main() {
    val tmp1 = Class08("T-shirt", "Large")
    val tmp2 = Class08("T-shirt", "Small")
    println("tmp1+tmp2 = ${tmp1 + tmp2}")


    val t1 = CustomTime(1, 1, 1)
    val t2 = CustomTime(1, 1, 4)
    println("t1[0] = ${t1[0]}")

}

class Class08(val type: String, val size: String) {

    operator fun plus(other: Class08): String {
        return type + size + " " + other.type + other.size
    }
}

class CustomTime(val hour: Int, val min: Int, val sec: Int) {
    private fun toSeconds(): Int {
        return hour * 3600 + min * 60 + sec
    }

    private fun fromSeconds(totalSec: Int): CustomTime {
        val h = totalSec / 3600
        val m = (totalSec % 3600) / 60
        val s = totalSec % 60
        return CustomTime(h, m, s)
    }

    operator fun plus(other: CustomTime): CustomTime {
        val totalSec = this.toSeconds() + other.toSeconds()
        return fromSeconds(totalSec)
    }

    operator fun minus(other: CustomTime): CustomTime {
        val totalSec = this.toSeconds() - other.toSeconds()
        return fromSeconds(totalSec)
    }

    operator fun times(multiplier: Int): CustomTime {
        val totalSec = this.toSeconds() * multiplier
        return fromSeconds(totalSec)
    }

    operator fun get(index: Int): String {
        val listOf = listOf("$hour hours", "$min minutes", "$sec seconds")
        return listOf.getOrElse(index) { "ERROR" }
    }
}
