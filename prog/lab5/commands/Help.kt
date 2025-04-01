package commands

import utils.CommandHandler
import utils.StandardConsole

class Help(private val console: StandardConsole,
           private val commandHandler: CommandHandler
) : Command(name = "help", description = "вывести справку по доступным командам") {

    override var supportsDataCollection: Boolean = false

    override fun execute() {
        commandHandler.getCommands().forEach{ (name, command) -> console.printer(command.toString())}
        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {
        TODO("Not yet implemented")
    }

}

