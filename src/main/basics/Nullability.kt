package basics

object Nullability {
    var safeOperation: String? = null

    fun nullableStringCase(){
        var b: String? = "abc"
        val lengthWithoutElvis = verifyLengthWithoutElvis(b)
        val lengthWithElvis = verifyLengthWitElvis(b)
        println(lengthWithoutElvis)
        println(lengthWithElvis)
        b = null
        print(b)
    }

    fun safeOperations(){
        print(safeOperation?.length)
        safeOperation = "1"
        print(safeOperation!!.length)
    }

    private fun verifyLengthWithoutElvis(entry: String?): Int {
        return if (entry != null) entry.length else -1
    }

    private fun verifyLengthWitElvis(entry: String?): Int {
        return entry?.length ?: -1
    }
}