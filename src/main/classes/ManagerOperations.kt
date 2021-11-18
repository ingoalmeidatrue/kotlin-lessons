package classes

class ManagerOperations: UserOperations() {

    fun deleteByStatus(status: ProfessionalStatus) {
        users
            .filter { user -> user.professionalStatus == status }
            .forEach { user ->
                users.remove(user)
                println("Usuário ${user.name} removido por estar com flag - Open to Work - no LinkedIn ")
            }
    }

    fun getAll(): List<User> {
        return super.users
    }

}