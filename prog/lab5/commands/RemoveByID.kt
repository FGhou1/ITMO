package commands

import utils.CheckValidation
import utils.MovieCollection
import utils.StandardConsole

class RemoveByID(private val console: StandardConsole,
           private val movieCollection: MovieCollection
) : Command(name = "remove_by_id", description = "удалить элемент из коллекции по его id") {

    override var supportsDataCollection: Boolean = true

    val checkValidation = CheckValidation()

    override fun execute() {
        console.printer("Введите id элемента, который хотите удалить:")
        var id = checkValidation.readInt(console)
        movieCollection.getMovies().forEach{ movie ->
            if( movie.id == id ) {
                movieCollection.removeMovie(console, movie);
                console.printer("Элемент успешно удален")}
            else{ console.printError("Элемента с таким id нет") }}

        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {

        if (list.isEmpty()) { console.printError("Не указан id для удаления.") ; return }

        val id = checkValidation.checkInt(console, list.first())

        // Ищем и удаляем фильм по указанному id
        val movie = movieCollection.getMovies().find { it.id == id }
        if (movie != null) {
            movieCollection.removeMovie(console, movie)
            console.printer("Элемент успешно удален")
        } else {
            console.printError("Элемента с таким id нет")
        }

        console.addToHistory(name)
    }
}
