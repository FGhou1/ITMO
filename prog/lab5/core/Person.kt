package core

class Person(val name: String, passportID: String, var hairColor: Color?) {

    var passportID: String = passportID
        set(value) {
            require(value.length >= 6) { "Длина passportID должна быть не менее 6 символов" }
            require(passportIDs.add(value)) { "passportID должен быть уникальным" }
            field = value
        }

    init {
        require(name.isNotEmpty()) { "Имя не может быть пустым" }
        this.passportID = passportID
    }

    companion object {
        // Хранилище для проверки уникальности passportID
        private val passportIDs: MutableSet<String> = mutableSetOf()
    }

    override fun toString(): String {
        return "Person(name='$name', passportID='$passportID', hairColor=$hairColor)"
    }
}