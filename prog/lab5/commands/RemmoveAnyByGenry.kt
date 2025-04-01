package commands

import core.Movie
import core.MovieGenre
import utils.CheckValidation
import utils.MovieCollection
import utils.StandardConsole

class RemmoveAnyByGenry(private val console: StandardConsole,
                        private val movieCollection: MovieCollection
) : Command(name = "remove_any_by_genre", description = "удалить из коллекции один элемент, значение поля genre которого эквивалентно заданному") {

    override var supportsDataCollection: Boolean = true

    override fun execute() {

        val checkValidation = CheckValidation()

        console.printer("Введите genre фильма, по которому вы хотите его удалить: ")

        val genre = checkValidation.readEnum(console, MovieGenre::class.java)

        try { movieCollection.getMovies().forEach{ movie ->  if (movie.genre == genre) { movieCollection.removeMovie(console, movie)} }}
        catch (e: NoSuchElementException){ console.printError("В массиве нет элемента с таким номером") }

        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {

        if (list.size == 1){ val checkValidation = CheckValidation()

            val genre = checkValidation.checkEnum(console, MovieGenre::class.java, list[0])

            try { movieCollection.getMovies().forEach{ movie ->  if (movie.genre == genre) { movieCollection.removeMovie(console, movie)} }}
            catch (e: NoSuchElementException){ console.printError("В массиве нет элемента с таким номером") }
        }
        else { console.printError("Неправильное количество элементов") }

    }
}