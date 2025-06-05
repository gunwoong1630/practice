package org.example.validation

class SomeEntity(
    var id:Long = -1,
    var sf1:String,
    var sf2:String,
    var sf3:String,
    var inf:Int,
    var df:Double,
    var bf:Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SomeEntity

        if (id != other.id) return false
        if (inf != other.inf) return false
        if (df != other.df) return false
        if (bf != other.bf) return false
        if (sf1 != other.sf1) return false
        if (sf2 != other.sf2) return false
        if (sf3 != other.sf3) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + inf
        result = 31 * result + df.hashCode()
        result = 31 * result + bf.hashCode()
        result = 31 * result + sf1.hashCode()
        result = 31 * result + sf2.hashCode()
        result = 31 * result + sf3.hashCode()
        return result
    }
}
