package commands

import utils.MovieCollection
import utils.StandardConsole

class AverageOfOscarsCount(
    private val console: StandardConsole,
    private val movieCollection: MovieCollection
) : Command(
    name = "average_of_oscars_count",
    description = "вывести среднее значение поля oscarsCount для всех элементов коллекции"
) {

    override var supportsDataCollection: Boolean = false

    override fun execute() {

        val movies = movieCollection.getMovies()

        if (movies.isNotEmpty()) {
            val totalOscars = movies.sumOf { it.oscarsCount }
            val averageOscars = totalOscars.toDouble() / movies.size
            console.printer("Среднее значение поля oscarsCount: $averageOscars")
        } else {
            console.printError("Коллекция пуста, среднее значение невозможно вычислить.")
        }
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {
        TODO("Not yet implemented")
    }
}


