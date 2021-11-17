package basics

import kotlin.random.Random

object Loops {
    private val names = listOf("Amanda", "Breno", "Guilherme", "Vithorio")
    private val teamComposition = listOf(
        hashMapOf("Nome" to "Amanda", "Cargo" to "Desenvolvedora IOs" ),
        hashMapOf("Nome" to "Breno", "Cargo" to "Desenvolvedor Android" ),
        hashMapOf("Nome" to "Guilherme", "Cargo" to "Desenvolvedor IOs" ),
        hashMapOf("Nome" to "Vithorio", "Cargo" to "Desenvolvedor Android" ),
    )

    fun inlineForLoop(){
        for (item in names) println(item)
    }

    fun rangeForLoop(){
        for (i in 1..3) {
            println(i)
        }
    }

    fun rangeForLoopWithDownTo(){
        for (i in 10 downTo 2) {
            println(i)
        }
    }

    fun rangeForLoopWithDownToAndSteps(){
        for (i in 10 downTo 2 step 4) {
            println(i)
        }
    }

    fun forWithDisruption(){
        for ((index, value) in names.withIndex()) {
            println("O elemento no index $index é $value")
        }
    }

    fun forEachInTeamComposition(){
        teamComposition.forEach { members ->
            println("${members.getValue("Nome")} - ${members.getValue("Cargo")}")
        }
    }

    fun whileLoop(){
        var i = 3
        while (i >= 0) {
            println(names[i])
            i--
        }
    }

    fun doWhileLoop(){
        val randomInts = List(5) { Random.nextInt() }
        do {
            val y = if (randomInts[0]%2 == 0) randomInts[0] else null
        } while (y != null)
    }

    fun labeledFor(){
        loop@ for (i in 1..5) {
            println("i tem valor $i")
            for (j in 1..5) {
                println("j tem valor $j")
                if (j == 3) break@loop
//                if (j == 3) continue@loop
            }
        }
    }

    fun labeledForEach(){
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
            print("$it ")
        }
        print(" - Finalizado o labeled ForEach")
    }

}