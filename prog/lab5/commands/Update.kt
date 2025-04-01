package commands

import core.*
import utils.CheckValidation
import utils.MovieCollection
import utils.StandardConsole
import java.util.Date

class Update(private val console: StandardConsole,
           private val movieCollection: MovieCollection
) : Command(name = "update", description = "обновить значение элемента коллекции, id которого равен заданному") {

    override var supportsDataCollection: Boolean = true

    override fun execute() {

        val checkValidation = CheckValidation()

        console.printer("Введите id элемента который хотите изменить: ")

        val id = checkValidation.readInt(console)

        movieCollection.getMovies().find { it.id == id }?.let { movie ->

            console.printer("Какой параметр вы хотите изменить?")
            console.printer(movie.toString())

            // Получение полей объекта
            val fields = movie.toString()
                .substringAfter("(")
                .split(", ")
                .map { it.split("=").first() }

            // Печатаем список полей для выбора
            fields.forEachIndexed { index, fieldName ->
                console.printer("$index: $fieldName")
            }

            // Считываем выбор пользователя
            val choiceIndex = checkValidation.readInt(console)
            val fieldToChange = fields.getOrNull(choiceIndex)

            if (fieldToChange != null) {
                console.printer("Введите новое значение для $fieldToChange")
                val newValue = console.readln() // Или любой метод ввода

                // Создаем копию объекта с измененным полем
                val updatedMovie = when (fieldToChange) {
                    "id" -> movie.copy(id = newValue.toInt())
                    "name" -> movie.copy(name = newValue)
                    "coordinates" -> {
                        console.printer("Введите координату x:")
                        val x = console.readln().toLong()
                        console.printer("Введите координату y:")
                        val y = console.readln().toLong()
                        movie.copy(coordinates = Coordinates(x, y))
                    }
                    "creationDate" -> movie.copy(creationDate = Date(newValue))
                    "oscarsCount" -> movie.copy(oscarsCount = newValue.toInt())
                    "genre" -> movie.copy(genre = MovieGenre.valueOf(newValue))
                    "mpaaRating" -> movie.copy(mpaaRating = newValue.takeIf { it.isNotEmpty() }?.let { MpaaRating.valueOf(it) })
                    "director" -> movie.copy(director = newValue.takeIf { it.isNotEmpty() }?.let { Person(name = "123", passportID = "123123", hairColor = Color.BLACK) })
                    else -> movie
                }
                console.printer("Изменение выполнено")
            } else {
                console.printer("Неверный выбор!")
            }
        }
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {

        movieCollection.getMovies().find { it.id == list[0].toInt() }?.let { movie ->

            when (list[1]) {
                "id" -> movie.copy(id = list[2].toInt())
                "name" -> movie.copy(name = list[2])
                "coordinates" -> { movie.copy(coordinates = Coordinates(list[2].toLong(), list[3].toLong())) }
                "creationDate" -> movie.copy(creationDate = Date())
                "oscarsCount" -> movie.copy(oscarsCount = list[2].toLong().toInt())
                "genre" -> movie.copy(genre = MovieGenre.valueOf(list[2]))
                "mpaaRating" -> movie.copy(mpaaRating = list[2].takeIf { it.isNotEmpty() }
                    ?.let { MpaaRating.valueOf(it) })
                "director" -> movie.copy(director = list[2].takeIf { it.isNotEmpty() }
                    ?.let { Person(name = "123", passportID = "123123", hairColor = Color.BLACK) })
                else -> movie
            }
            console.printer("Изменение выполнено")
        }
    }
}