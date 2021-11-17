package basics

object Variables {

    //VAL CONCEPT
    val immutableVariable = "Minha primeira variável imutável"
    open val immutableOpenVariable = "Minha primeira variável aberta"
    internal val internalImmutableVariable = "Minha primeira variável privada"
    private val privateImmutableVariable = "Minha primeira variável privada"

    //VAR CONCEPT
    var mutableVariable = "Minha primeira variável mutável"

    //CONST CONCEPT
    const val CONSTANT_VALUE = "Minha primeira constante"

    //LAZY CONCEPT
    val immutablePublicationLazyVariable by lazy (LazyThreadSafetyMode.PUBLICATION) {
        val a = 1 + 1
        "Minha primeira variável imutável lazy com resultado de a = $a"
    }
    val immutableSynchronizedLazyVariable by lazy (LazyThreadSafetyMode.SYNCHRONIZED) { "Minha primeira variável imutável lazy" }
}