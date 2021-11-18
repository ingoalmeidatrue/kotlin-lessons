package classes

interface BasicOperations<T> {
    fun add(element: T): List<T>
    fun findById(id: Int): T?
    fun deleteById(id: Int): T?
}