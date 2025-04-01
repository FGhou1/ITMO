package commands

import utils.CheckValidation
import utils.MovieCollection
import utils.StandardConsole

class RemoveGreater(private val console: StandardConsole,
                    private val movieCollection: MovieCollection
) : Command(name = "remove_greater", description = "удалить из коллекции все элементы, превышающие заданный") {

    override var supportsDataCollection: Boolean = true

    override fun execute() {

        val checkValidation = CheckValidation()

        console.printer("Введите id фильма, превышающие который будут удалены: ")

        val id = checkValidation.readInt(console)

        try { removeGreaterThan(id) }
        catch (e: NoSuchElementException){ console.printError("В массиве нет элемента с таким номером") }
    }

    override fun execute(list: MutableList<String>) {

        if (list.size == 1){ val checkValidation = CheckValidation()
            val inputId = checkValidation.checkInt(console, list.first())
            removeGreaterThan(inputId) }
        else { console.printError("Неправильное количество элементов") }
        console.addToHistory(name)
    }

    private fun removeGreaterThan(id: Int) {
        val moviesToRemove = movieCollection.getMovies().filter { it.id > id }

        if (moviesToRemove.isEmpty()) {
            console.printer("Нет фильмов с id больше $id.")
            return
        }

        moviesToRemove.forEach { movieCollection.removeMovie(console, it) }
        console.printer("Удалено ${moviesToRemove.size} фильмов с id больше $id.")
    }
}


