package advanced

import classes.ProfessionalStatus
import classes.User

object ScopeFunctions {
    object letScope {
        // let is often used for executing a code block only with non-null values.
        // Another case for using let is introducing local variables with a limited scope for improving code readability
        fun variableValue(){
            val empty = "test".let {
                println(it)
                it.isEmpty()
            }
            println(" is empty: $empty")
        }

        fun printNonNull() {
            val str: String? = null
            str?.let {
                println(it)
            }
        }

        fun printIfBothNonNull(strOne: String?, strTwo: String?) {
            strOne?.let { firstString ->
                strTwo?.let { secondString ->
                    println("$firstString : $secondString")
                }
            }
        }

        fun singleFunction(){
            val numbers = mutableListOf("one", "two", "three", "four", "five")
            numbers.map { it.length }.filter { it > 3 }.let(::println)
        }

        fun labeledLet(strOne: String?, strTwo: String?) {
            val externalValue = strOne?.let firstLet@ { firstString ->
                val internalValue = strTwo?.let { secondString ->
                    when (firstString) {
                        "Harold" -> {
                            println("Harold na área")
                            return@firstLet "Harold"
                        }
                        "Kappa" -> {
                            println("Kappa na área")
                            return@let "Kappa"
                        }
                        else -> {
                            println("$firstString : $secondString")
                            return
                        }
                    }
                }
                println("Scopo Let Externo recebeu do Let Interno o valor: $internalValue")
            }
            println("Let Externo retornou o valor: $externalValue")
        }
    }

    object withScope {
        // We recommend with for calling functions on the context object without providing the lambda result.
        // Another use case for with is introducing a helper object whose properties or functions will be used for calculating a value.
        // In the code, with can be read as “ with this object, do the following.”
        fun callAnotherServiceSituation(){
            val users = mutableListOf("Kaio", "Denis", "Marina")
            with(users) {
                println("Argumento passado contêm $size elementos")
                forEach {
                    println("Mandando mensagem de alarme para $it")
                }
            }
        }

        fun returnValue(){
            val user = User(1, "Harold", "openHarold@gmail.com", professionalStatus = ProfessionalStatus.OPEN_TO_PROPOSALS)
            var firstAndLast = with(user) {
                "Você, ${user.name}, concorda com os termos e " +
                "permite a comunicações de marketin para o seu email pessoal ($email)."
            }
            println(firstAndLast)
            firstAndLast = with(User(1, "Harold", "openHarold@gmail.com", professionalStatus = ProfessionalStatus.OPEN_TO_PROPOSALS)){
                """
                    Você,${user.name} , concorda com os termos \n
                    permite a comunicações de marketin para o seu email pessoal ($email).
                """.trimIndent()
            }
            println(firstAndLast)
        }
    }

    object runScope {
        fun getNullableLength(entry: String?) {
            entry?.run {
                println("É vazio? " + isEmpty())
                println("É nulo ou contém apenas espaçamentos? " + isNullOrBlank())
                println("Tamanho = $length")
                length
            }
        }
    }

    object applyScope {

    }
    object alsoScope {

    }
}