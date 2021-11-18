package classes

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val age: Int? = null,
    val professionalStatus: ProfessionalStatus
) {
    init {
        require(id in 1..100) { "Id deve estar compreendido entre 1 e 100" }
        require("^[A-Za-z](.*)([@])(.+)(\\.)(.+)".toRegex().matches(email)) { throw Exception("Email não está com o formato correto") }
    }
}
