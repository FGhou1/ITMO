package commands

import utils.MovieCollection
import utils.StandardConsole

class Info(private val console: StandardConsole,
           private val movieCollection: MovieCollection
) : Command(name = "show", description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении") {

    override var supportsDataCollection: Boolean = false

    override fun execute() {
        console.printer("Тип коллекции: ${movieCollection.javaClass.simpleName}")
        console.printer("Дата инициализации коллекции: ${movieCollection.getCreationTime()}")
        console.printer("Количество элементов: ${movieCollection.getMovies().size}")
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {
        TODO("Not yet implemented")
    }
}

