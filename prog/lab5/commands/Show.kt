package commands

import utils.MovieCollection
import utils.StandardConsole

class Show(private val console: StandardConsole,
           private val movieCollection: MovieCollection
) : Command(name = "show", description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении") {

    override var supportsDataCollection: Boolean = false

    override fun execute() {
        if (movieCollection.getMovies().size > 0){ console.printer("Фильмы: ${(movieCollection.getMovies().map { it.name }).toString().drop(1).dropLast(1)}")}
        else{ console.printer("Объект пустой") }
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) { TODO("Not yet implemented") }
}