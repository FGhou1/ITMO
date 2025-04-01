package commands

import utils.MovieCollection
import utils.StandardConsole
import java.io.File

class Save(private val console: StandardConsole,
           private val movieCollection: MovieCollection
) : Command(name = "save", description = "сохранить коллекцию в файл") {

    override var supportsDataCollection: Boolean = false

    override fun execute() {

        val file = File(console.getPath())

        movieCollection.getMovies().forEach{ movie ->
            file.writeText(
                """
                <root>
                    <movie>
                        <id>${movie.id}</id>
                        <name>${movie.name}</name>
                        <coordinates>
                            <x>${movie.coordinates.x}</x>
                            <y>${movie.coordinates.y}</y>
                        </coordinates>
                        <creationDate>${movie.creationDate}</creationDate>
                        <oscarsCount>${movie.oscarsCount}</oscarsCount>
                        <genre>${movie.genre}</genre>
                        <mpaaRating>${movie.mpaaRating}</mpaaRating>
                        <director>
                            <name>${movie.director?.name}</name>
                            <passportID>${movie.director?.passportID}</passportID>
                            <hairColor>${movie.director?.hairColor}</hairColor>
                        </director>
                    </movie>
                </root>
                """.trimIndent())
        }
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {
        TODO("Not yet implemented")
    }
}