package commands

import utils.CommandHandler
import utils.MovieCollection
import utils.StandardConsole

class History(private val console: StandardConsole,
            private val commandHandler: CommandHandler
) : Command(name = "history", description = "вывести последние 14 команд (без их аргументов)") {

    override var supportsDataCollection: Boolean = false

    override fun execute() {
        console.getCommandHistory().forEach{ command -> console.printer(command) }
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {
        TODO("Not yet implemented")
    }
}