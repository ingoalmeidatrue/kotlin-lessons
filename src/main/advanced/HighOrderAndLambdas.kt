package advanced

import java.util.*

object HighOrderAndLambdas {

    object Lambda{
        //Lambda expressions and anonymous functions are function literals. Function literals are functions that are not declared but are passed immediately as an expression.
        val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
        val compactSum = { x: Int, y: Int -> x + y }

        fun useSums(a: Int, b: Int){
            println(sum(a,b))
            println(compactSum(a,b))
        }

        fun lambdaConcat(entry: List<String>){
            entry.filter { it.length == 5 }.sortedBy { it }.map { it.uppercase() }
        }
    }

    object AnonymousFunctions {
        //The lambda expression syntax above is missing one thing – the ability to specify the function’s return type.
        val sum = fun(x: Int, y: Int): Int {
            return x + y
        }
        val compactSum = fun(x: Int, y: Int): Int = x + y

        fun useSums(a: Int, b: Int){
            println(sum(a, b))
            println(compactSum(a, b))
        }
    }

    object LiteralsWithReceiver {
        //This behavior is similar to that of extension functions, which also allow you to access the members of the receiver object inside the function body.
        val sum = fun String.(other: Int): Int? = this.toIntOrNull()?.plus(other)
        val compactSum: String.(Int) -> Int? = { other -> toIntOrNull()?.plus(other) }

        fun useSums(a: Int, b: Int){
            println(sum(a.toString(), b))
            println(compactSum(a.toString(), b))
        }
    }




    object HighOrderFunction{
        //A higher-order function is a function that takes functions as parameters, or returns a function.

        //////////Function as Parameter with Lambda/////////
        val simpleLambda = { println("Seja bem vindo ao aplicativo PagBank!") }
        val customLambda = { firstName: String , secondName: String -> println("Seja bem vindo ao aplicativo PagBank $firstName $secondName!") }
        fun openingMessage(blackBox: () -> Unit) {
            blackBox()
        }
        //call openingMessage(simpleLambda)  in main
        fun customOpeningMessage(firstName: String, secondName: String, blackBox: (String, String) -> Unit) {
            blackBox(firstName, secondName)
        }
        //call customOpeningMessage("Kaio", "Soato", customLambda)  in main


        //////////Hide Object Function/////////
        //In Kotlin the :: converts functions into a lambda (Search Reflection in Kotlin)
        private val lambdaMul = { x: Int, y: Int -> x * y }
        private fun mul(a: Int, b: Int): Int {
            return a*b
        }
        //High-Order Function returns Function for anyone
        fun openMultiplier() : ((Int,Int) -> Int){
//            return mul
//            return lambdaMul
            return ::mul
        }
        //call openMultiplier(1, 2) in main


        ////////Playing with High-Order Functions//////////
        private fun takesMultipleFunctions(input: String, validators: List<(String) -> Unit>): Unit =
            validators.forEach { it(input) }

        private val emptyStringValidator = {s: String -> if(s.isEmpty()) throw Exception("123123") }

        fun validateEntry(entry: String) {
            try {
                takesMultipleFunctions(
                    entry,
                    listOf(
                        { s -> if(s.length < 10) throw Exception("Entry é menor que 10") },
                        { emptyStringValidator },
                        { s -> if(s.length > 20) throw Exception("Entry é maior que 20") },
                    )
                )
            }catch (e: Exception){
                println(e)
            }
        }
    }
}