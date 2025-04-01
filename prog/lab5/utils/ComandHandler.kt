package utils
import commands.Command

class CommandHandler{

    private val commands: MutableMap<String, Command> = mutableMapOf()

    fun register(commandName: String, command: Command) {
        commands[commandName] = command
    }

    fun getCommands(): Map<String, Command> {
        return commands
    }
}
