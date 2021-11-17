package basics

object DataTypes {

    //NUMBERS
    val myNum: Int = 5   //2147483648 to 2147483647
    val myShortNum: Short = 5000    //-32768 to 32767
    val myDoubleNum: Double = 5.99  //1.7e−308 to 1.7e+038
    val myLongNum: Long = 15000000000L  //-9223372036854775808 to 9223372036854775808

    //CHAR AND STRINGS
    val myLetter = 'D'
    val myBoolean = true
    val myText = "Hello"

    //LISTS
    val myList: List<String> = listOf("teste")
    val myPreAllocatedArray = IntArray(5)
    val myPreAllocatedArrayWithInitialValues = IntArray(5) { 42 }
    var myPreAllocatedArrayWithLambdaFunction = IntArray(5) { it * 2 }

    //MUTABLE TYPES
    var myMutableList = mutableListOf<String>()
    var myMutableMap = mutableMapOf<String,String>()
    var myMutableSet = mutableSetOf<String>()

}