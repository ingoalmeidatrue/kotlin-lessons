package classes

class ManagerOperations: UserOperations() {

    fun deleteByStatus(status: ProfessionalStatus): Int {
        val filteredUsers = users.filter { user -> user.professionalStatus == status }
        filteredUsers.forEach { user ->
            users.remove(user)
            println("Usuário ${user.name} removido por estar com flag - Open to Work - no LinkedIn ")
        }
        return filteredUsers.size
    }

    fun getAll(): List<User> {
        return super.users
    }

}