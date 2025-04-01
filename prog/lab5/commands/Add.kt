package commands

import core.*
import utils.*
import java.util.Date

class Add(private val console: StandardConsole,
           private val movieCollection: MovieCollection
) : Command(name = "add", description = "добавить новый элемент в коллекцию") {

    override var supportsDataCollection: Boolean = true

    override fun execute() {

        val checkValidation = CheckValidation()

        console.printer("Введите id (целое число):")
        val id = checkValidation.readInt(console)

        console.printer("Введите название фильма (не пустое):")
        val nameFilm = checkValidation.readNonEmptyString(console)

        console.printer("Введите координаты x (целое число):")
        val x = checkValidation.readLong(console)

        console.printer("Введите координаты y (целое число):")
        val y = checkValidation.readLong(console)

        console.printer("Введите кол-во оскаров (целое положительное число):")
        val oscarsCount = checkValidation.readPositiveInt(console)

        console.printer("Хотите добавить рейтинг фильма? (yes/no):")

        val mpaaRating = if (checkValidation.readYesOrNo(console)) {
            console.printer("Введите рейтинг (G, PG_13, R, NC_17):")
            checkValidation.readEnum(console, MpaaRating::class.java)
        } else { null }

        console.printer("Введите жанр фильма (ACTION, WESTERN, HORROR, SCIENCE_FICTION):")
        val genre = checkValidation.readEnum(console, MovieGenre::class.java)

        console.printer("Хотите добавить создателя фильма? (yes/no):")

        val director = if (checkValidation.readYesOrNo(console)) {
            console.printer("Введите имя создателя (не пустое):")
            val personName = checkValidation.readNonEmptyString(console)

            console.printer("Введите его паспорт (6 символов):")
            val personPassportID = checkValidation.readPassportID(console)

            console.printer("Введите цвет волос (BLACK, BROWN, BLONDE, RED, WHITE, GREY, OTHER):")
            val personHairColor = checkValidation.readEnum(console, Color::class.java)

            Person(
                name = personName,
                passportID = personPassportID,
                hairColor = personHairColor
            )
        } else { null }

        movieCollection.addMovie( console,
            Movie(
                id = id,
                name = nameFilm,
                coordinates = Coordinates(x = x, y = y),
                creationDate = Date(),
                oscarsCount = oscarsCount,
                genre = genre,
                mpaaRating = mpaaRating,
                director = director
            )
        )

        console.addToHistory(nameFilm)
    }


    override fun execute(list: MutableList<String>) {
        try {
            val id = list[0].trim().toInt()
            val name = list[1].trim()
            if (name.isEmpty()) throw IllegalArgumentException("Имя не должно быть пустым")

            val x = list[2].trim().toLong()
            val y = list[3].trim().toLong()

            val oscarsCount = list[4].trim().toInt()
            if (oscarsCount <= 0) throw IllegalArgumentException("Количество оскаров должно быть положительным")

            val genre = MovieGenre.valueOf(list[5])

            val mpaaRating = try {
                MpaaRating.valueOf(list[6].trim())
            } catch (e: IllegalArgumentException) {
                null
            }

            val personName = list[7].trim().takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException("Имя режиссера не должно быть пустым")

            val personPassportID = list[8].trim()
            if (personPassportID.toInt() == 6) throw IllegalArgumentException("Невалидный ID паспорта")

            val personHairColor = Color.valueOf(list[9].trim())

            val director = try {
                Person(
                    name = personName,
                    passportID = personPassportID,
                    hairColor = personHairColor
                )
            } catch (e: IllegalArgumentException) {
                null
            }

            movieCollection.addMovie(console,
                Movie(
                    id = id,
                    name = name,
                    coordinates = Coordinates(x = x, y = y),
                    creationDate = Date(),
                    oscarsCount = oscarsCount,
                    genre = genre,
                    mpaaRating = mpaaRating,
                    director = director
                )
            )
        } catch (e: NumberFormatException) {
            console.printError("Ошибка формата числа")
            Thread.sleep(100)
        } catch (e: IllegalArgumentException) {
            console.printError(e.message ?: "Ошибка валидации")
            Thread.sleep(100)
        } catch (e: Exception) {
            console.printError("Произошла неизвестная ошибка")
            Thread.sleep(100)
        }
    }
}

