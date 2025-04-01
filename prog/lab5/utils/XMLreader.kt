package utils

import java.io.*
import core.*

import org.w3c.dom.Element
import org.xml.sax.InputSource
import java.text.SimpleDateFormat
import javax.xml.parsers.DocumentBuilderFactory
import java.util.*

class XMLreader(private val console: StandardConsole) {

    /**
     * Считываем xml файл.
     * @param file_path путь к файлу
     */

    fun read(file_path: String, collection: MovieCollection): MovieCollection {

        val fileInputStream = FileInputStream(file_path)
        val inputStreamReader = InputStreamReader(fileInputStream, "UTF-8")
        val docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        val document = docBuilder.parse(InputSource(inputStreamReader))

        document.documentElement.normalize()

        val movies = document.getElementsByTagName("movie")

        for (i in 0 until movies.length) {
            val movieNode = movies.item(i) as Element

            val id = movieNode.getElementsByTagName("id").item(0).textContent
            val name = movieNode.getElementsByTagName("name").item(0).textContent

            val coordinatesNode = movieNode.getElementsByTagName("coordinates").item(0) as Element
            val x = coordinatesNode.getElementsByTagName("x").item(0).textContent
            val y = coordinatesNode.getElementsByTagName("y").item(0).textContent

            val creationDate = movieNode.getElementsByTagName("creationDate").item(0).textContent
            val format = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
            val dateTime: Date = format.parse(creationDate)

            val oscarsCount = movieNode.getElementsByTagName("oscarsCount").item(0).textContent
            val genre = movieNode.getElementsByTagName("genre").item(0).textContent

            // Проверка на существование и корректность mpaaRating
            val mpaaRating = try { val ratingText = movieNode.getElementsByTagName("mpaaRating").item(0)?.textContent
                if (!ratingText.isNullOrEmpty()) MpaaRating.valueOf(ratingText) else null
            } catch (e: IllegalArgumentException) { null }

            val personNode = movieNode.getElementsByTagName("director").item(0) as? Element

            val director = if (personNode != null) {
                try {
                    val personPassportID = personNode.getElementsByTagName("passportID").item(0)?.textContent ?: "unknown"
                    val personHairColor = personNode.getElementsByTagName("hairColor").item(0)?.textContent ?: "UNKNOWN"
                    val personName = personNode.getElementsByTagName("name").item(0)?.textContent ?: ""

                    if (personName.isNotEmpty()) {
                        Person(
                            name = personName,
                            passportID = personPassportID,
                            hairColor = try { Color.valueOf(personHairColor)
                            } catch (e: IllegalArgumentException) { Color.OTHER }
                        )
                    } else { console.printError("Имя создателя фильма: \"$name\" неизвестно") ; Thread.sleep(100); null }
                } catch (e: Exception) {
                    console.printError(e.message.toString())
                    null
                }
            } else { console.printError("Тег director не найден"); Thread.sleep(100) ; null }

            val movie = Movie(
                id = id.toInt(),
                name = name,
                coordinates = Coordinates(x = x.toLong(), y = y.toLong()),
                creationDate = dateTime,
                oscarsCount = oscarsCount.toInt(),
                genre = MovieGenre.valueOf(genre),
                mpaaRating = mpaaRating,
                director = director
            )

            collection.addMovie(console, movie)
        }
        val messages = Messages()
        console.printer(messages.mode())

        return collection
    }
}





