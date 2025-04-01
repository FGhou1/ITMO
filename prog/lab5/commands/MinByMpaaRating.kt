package commands

import core.Movie
import core.MpaaRating
import core.MpaaRating.*
import utils.MovieCollection
import utils.StandardConsole

class MinByMpaaRating(private val console: StandardConsole,
           private val movieCollection: MovieCollection
) : Command(name = "min_by_mpaa_rating", description = "вывести любой объект из коллекции, значение поля mpaaRating которого является минимальным") {

    override var supportsDataCollection: Boolean = false

    fun checkRating( mpaaRating : MpaaRating) : Int { when(mpaaRating){ G -> return 1 ; PG_13 -> return 2 ; R ->  return 3 ; NC_17 -> return 4 } }

    override fun execute() {

        var minMpa : Movie = movieCollection.getMovies().toList()[0]

        movieCollection.getMovies().forEach { movie ->
            var mpaaRatingNew = movie.mpaaRating?.let { checkRating(it) } ?: run { 0 }
            var mpaaRatingOld = minMpa.mpaaRating?.let { checkRating(it) } ?: run { 0 }
            if (mpaaRatingNew < mpaaRatingOld) {
                minMpa = movie
            }
        }
        console.printer(minMpa.name)
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {

        if (list.isNotEmpty()) {

            var minMpa: Movie = movieCollection.getMovies().firstOrNull() ?: return

            movieCollection.getMovies().forEach { movie ->
                val mpaaRatingNew = movie.mpaaRating?.let { checkRating(it) } ?: 0
                val mpaaRatingOld = minMpa.mpaaRating?.let { checkRating(it) } ?: 0
                if (mpaaRatingNew < mpaaRatingOld) {
                    minMpa = movie
                }
            }
            // Используем первый элемент из списка для добавления в список истории
            console.printer(minMpa.name)
        }
    }
}