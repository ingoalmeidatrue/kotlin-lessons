import basics.BackingProperty
import basics.Variables

fun main (args: Array<String>) {
    //VARIABLES CONCEPTS
    println(Variables.immutableVariable)
    println(Variables.immutableOpenVariable)
    println(Variables.internalImmutableVariable)
    println(Variables.mutableVariable)
    println(Variables.CONSTANT_VALUE)

    //CONDITIONALS CONCEPT


    //BACKING PROPERTY AND FUNCTIONS
    val backingProperty = BackingProperty()
    println("Tamanho dos array de elementos: ${backingProperty.elementList.size}")
    backingProperty.addElements("Ingo Almeida")
    println("Tamanho dos array de elementos: ${backingProperty.elementList.size}")
    println("Primeira posição do array de elementos: ${backingProperty.elementList[0]}")
}