package advanced

import classes.ManagerOperations
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
            var notificationMessage = with(user) {
                "Você, ${user.name}, concorda com os termos e " +
                "permite a comunicações de marketin para o seu email pessoal ($email)."
            }
            println(notificationMessage)
            notificationMessage = with(User(1, "Harold", "openHarold@gmail.com", professionalStatus = ProfessionalStatus.OPEN_TO_PROPOSALS)){
                """
                    Você,${user.name} , concorda com os termos \n
                    permite a comunicações de marketin para o seu email pessoal ($email).
                """.trimIndent()
            }
            println(notificationMessage)
        }
    }

    object runScope {
        //Run is useful when your lambda contains both the object initialization and the computation of the return value.
        // Besides calling run on a receiver object, you can use it as a non-extension function. Lets you execute a block of several statements where an expression is required.
        class MultiportService(var url: String, var port: Int) {
            fun prepareRequest(): String = "Default request"
            fun query(request: String): String = "Result for query '$request'"
        }

        fun httpRequest(entry: String?) {
            val service = MultiportService("https://example.kotlinlang.org", 80)

            val result = service.run {
                port = 8080
                query(prepareRequest() + " to port $port")
            }
        }

        fun regexVerification(){
            val hexNumberRegex = run {
                val number = "0-9"
                val hexDigits = "A-Fa-f"
                val sign = "+-"

                Regex("[$sign]?[$number$hexDigits]+")
            }

            for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
                println(match.value)
            }
        }
    }

    object applyScope {
        //The common case for apply is the object configuration. Such calls can be read as “ apply the following assignments to the object.”
        data class Person(var name: String, var age: Int = 0, var city: String = "")

        fun createPerson(){
            val adam = Person(name = "Adam", age = 10).apply {
                age = 32
                city = "London"
            }
            println(adam)
        }
    }

    object alsoScope {
        //Use also for actions that need a reference rather to the object than to its properties and functions
        fun createManagerAndAddUsers(){
            val managerOperations = ManagerOperations()
            User(1, "Harold", "employedHarold@gmail.com", professionalStatus = ProfessionalStatus.EMPLOYED)
                .also { managerOperations.add(it) }
                .also { println("Usuário ${it.name} adicionado") }
        }
    }
}