package commands

import utils.MovieCollection
import utils.StandardConsole

class Clear(private val console: StandardConsole,
                 private val movieCollection: MovieCollection
) : Command(name = "clear", description = "очистить коллекцию") {

    override var supportsDataCollection: Boolean = false

    override fun execute() {
        movieCollection.getMovies().forEach{ movie -> movieCollection.removeMovie(console, movie) }
        console.printer("Коллекция очищена")
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {
        TODO("Not yet implemented")
    }
}