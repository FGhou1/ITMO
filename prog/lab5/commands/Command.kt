package commands

abstract class Command( val name: String, private val description: String,) {

    abstract var supportsDataCollection: Boolean

    abstract fun execute()

    abstract fun execute(list: MutableList<String>)

    override fun toString(): String { return "$name: $description" }
}
