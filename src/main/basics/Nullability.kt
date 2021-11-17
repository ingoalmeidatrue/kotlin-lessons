package basics

object Nullability {

    fun nullableStringCase(){
        var b: String? = "abc"
        val lengthWithoutElvis = verifyLengthWithoutElvis(b)
        val lengthWithElvis = verifyLengthWitElvis(b)
        println(lengthWithoutElvis)
        println(lengthWithElvis)
        b = null
        print(b)
    }

    private fun verifyLengthWithoutElvis(entry: String?): Int {
        return if (entry != null) entry.length else -1
    }

    private fun verifyLengthWitElvis(entry: String?): Int {
        return entry?.length ?: -1
    }
}