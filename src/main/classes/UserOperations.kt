package classes

open class UserOperations: BasicOperations<User> {
    protected var users = mutableListOf<User>()

    override fun add(element: User): List<User> {
        users.add(element)
        return users
    }

    override fun findById(id: Int): User? {
        return users.firstOrNull { user -> user.id == id }
    }

    override fun deleteById(id: Int): User? {
        val user = users.firstOrNull { user -> user.id == id }
        if (user != null){
            users.remove(user)
        }
        return user
    }
}