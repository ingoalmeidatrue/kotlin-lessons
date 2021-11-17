package basics

class BackingProperty {
    //BACKING PROPERTIES
    private val _elementList = mutableListOf<String>()

    val elementList: List<String>
        get() = _elementList


    //FUNCTIONS
    fun addElements(name: String){
        _elementList.add(name)
    }

}