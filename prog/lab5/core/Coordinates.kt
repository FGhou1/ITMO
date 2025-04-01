package core

data class Coordinates(
    val x: Long, // Поле не может быть null
    val y: Long // Максимальное значение поля: 215, Поле не может быть null
) {
    init {
        require(y <= 215) { "Значение поля y не может превышать 215" }
    }
}
