package basics

object Conditionals {
    fun useIfs(entry: String): String {
        if(entry.uppercase() == "REMO") return "Esporte de auto rendimento"
        else if(entry.uppercase() == "TÊNIS") return "Esporte de auto rendimento e técnica"
        else return "O que é ${entry}?"
    }

    fun useSwitch(entry: String): String {
        return when(entry.uppercase()) {
            "RAMON" -> "Cosplay de Picachu"
            "MINGARDI" -> "A amêndoa reinará"
            "INGO" -> "Vive na praia"
            "VICTOR", "CUNHA" -> "O rei da Função"
            "RODRIGO" -> "Mora na linha de trem"
            else -> "Ser humano não identificado"
        }
    }

    fun useVerifierSwitch(x: Int){
        val validNumbers = listOf(11,12,13,14)
        when (x) {
            in 1..10 -> println("x está compreendido entre 1 e 10")
            in validNumbers -> println("x está no grupo dos números válidos")
            !in 15..20 -> println("x está fora dos números válidos")
            else -> println("Algo de errado não está certo")
        }
    }
}