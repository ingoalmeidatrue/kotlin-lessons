package classes


fun main (){
    val userOperations = UserOperations()

    //NORMAL SCENARIO
    val harold = User(1, "Harold", "openHarold@gmail.com", professionalStatus = ProfessionalStatus.OPEN_TO_PROPOSALS)
    userOperations.add(harold)
    val foundHarold = userOperations.findById(harold.id)
    println("Usuário encontrado: $foundHarold")
    val deletedHarold = userOperations.deleteById(harold.id)
    println("Usuário deletado: $deletedHarold")
    val foundHaroldAfterDelete = userOperations.findById(harold.id)
    println("Usuário encontrado: $foundHaroldAfterDelete")

    //REQUIREMENT FAILED ID SCENARIO
    try {
        User(101, "Harold", "wrongIdHarold@gmail.com", professionalStatus = ProfessionalStatus.EMPLOYED)
    }catch (e: Exception) {
        println(e)
    }

    //REQUIREMENT FAILED EMAIL SCENARIO
    try {
        User(1, "Harold", "wrongMailHaroldgmail.com", professionalStatus = ProfessionalStatus.EMPLOYED)
    }catch (e: Exception) {
        println(e)
    }

    //MANAGER SCENARIO
    val managerOperations = ManagerOperations()
    User(1, "Harold", "employedHarold@gmail.com", professionalStatus = ProfessionalStatus.EMPLOYED).also { managerOperations.add(it) }
    User(2, "Harold", "badHarold1@gmail.com", professionalStatus = ProfessionalStatus.EMPLOYED_WITH_OPEN_TO_WORK_FLAG).also { managerOperations.add(it) }
    User(3, "Harold", "badHarold2@gmail.com", professionalStatus = ProfessionalStatus.EMPLOYED_WITH_OPEN_TO_WORK_FLAG).also { managerOperations.add(it) }
    User(4, "Harold", "badHarold3@gmail.com", professionalStatus = ProfessionalStatus.EMPLOYED_WITH_OPEN_TO_WORK_FLAG).also { managerOperations.add(it) }

    managerOperations.getAll().forEach { user ->
        println(user)
    }

    managerOperations.deleteByStatus(ProfessionalStatus.EMPLOYED_WITH_OPEN_TO_WORK_FLAG)

}