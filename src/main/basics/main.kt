package basics

fun main (args: Array<String>) {
    //VARIABLES CONCEPT
    println(Variables.immutableVariable)
    println(Variables.immutablePublicationLazyVariable)
    println(Variables.immutableSynchronizedLazyVariable)
    println(Variables.immutableOpenVariable)
    println(Variables.internalImmutableVariable)
    println(Variables.mutableVariable)
    println(Variables.anyMutableVariable)
    Variables.mutableVariable = "123123"
    Variables.anyMutableVariable = 1
    println(Variables.mutableVariable)
    println(Variables.anyMutableVariable)
    println(Variables.CONSTANT_VALUE)

    //DATA TYPES
    println(DataTypes.myNum)
    println(DataTypes.myBoolean)
    println(DataTypes.myText)
    DataTypes.myList.forEach { println(it) }
    DataTypes.myPreAllocatedArray.forEach { "${print(it)} " }
    println()
    DataTypes.myPreAllocatedArrayWithInitialValues.forEach { "${print(it)} " }
    println()
    DataTypes.myPreAllocatedArrayWithLambdaFunction.forEach { "${print(it)} " }

    //NULLABILITY
    Nullability.nullableStringCase()
    Nullability.safeOperations()

    //CONDITIONALS CONCEPT
    val remoDescription = Conditionals.useIfs("remo")
    println(remoDescription)
    val tenisDescription = Conditionals.useIfs("tênis")
    println(tenisDescription)
    val ramonDescription = Conditionals.useSwitch("Ramon")
    println(ramonDescription)
    val victorDescription = Conditionals.useSwitch("Victor")
    println(victorDescription)
    val cunhaDescription = Conditionals.useSwitch("Cunha")
    println(cunhaDescription)
    Conditionals.useVerifierSwitch(1)
    Conditionals.useVerifierSwitch(14)
    Conditionals.useVerifierSwitch(20)
    Conditionals.useVerifierSwitch(25)

    //BACKING PROPERTY AND FUNCTIONS
    val backingProperty = BackingProperty()
    println("Tamanho dos array de elementos: ${backingProperty.elementList.size}")
    backingProperty.addElements("Ingo Almeida")
    println("Tamanho dos array de elementos: ${backingProperty.elementList.size}")
    println("Primeira posição do array de elementos: ${backingProperty.elementList[0]}")


    //LOOPS CONCEPT
    Loops.inlineForLoop()
    Loops.rangeForLoop()
    Loops.rangeForLoopWithDownTo()
    Loops.rangeForLoopWithDownToAndSteps()
    Loops.forWithDisruption()
    Loops.forEachInTeamComposition()
    Loops.whileLoop()
    Loops.labeledFor()
    Loops.labeledForEach()
}