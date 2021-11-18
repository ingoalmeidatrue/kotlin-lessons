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
    // Initializer function can be called several times on concurrent access to uninitialized Lazy instance value,
    // but only the first returned value will be used as the value of Lazy instance.
    val immutablePublicationLazyVariable by lazy (LazyThreadSafetyMode.PUBLICATION) {
        val a = 1 + 1
        "Minha primeira variável imutável lazy com resultado de a = $a"
    }

    //Locks are used to ensure that only a single thread can initialize the Lazy instance.
    val immutableSynchronizedLazyVariable by lazy (LazyThreadSafetyMode.SYNCHRONIZED) { "Minha primeira variável imutável lazy" }
}