package commands

import utils.CommandHandler
import utils.StandardConsole
import java.io.File
import java.io.FileNotFoundException

class ExecuteScript(
    private val console: StandardConsole,
    private val commandHandler: CommandHandler
) : Command(
    name = "execute_script",
    description = "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводят"
) {

    // Указываем, что команда может собирать дополнительные данные
    override var supportsDataCollection: Boolean = true

    // Статическая (общая) переменная для отслеживания глубины рекурсии
    companion object { private var recursionDepth = 0 }

    override fun execute() {

        val lines = File("/home/maxim/IdeaProjects/lab5/src/script/script").readLines()
        var lastcommand = ""
        val dataCollection = mutableListOf<String>()
        var commandFlag = false

        for (line in lines) {
            if (line.startsWith("\\") || line.isEmpty()) {
                val command = line.drop(1).trim()

                if (commandFlag) {
                    commandHandler.getCommands()[lastcommand]?.execute(dataCollection)
                    commandFlag = false
                    dataCollection.clear()
                }

                if (commandHandler.getCommands()[command]?.supportsDataCollection == true) {
                    commandFlag = true
                } else {
                    commandHandler.getCommands()[command]?.execute()
                }

                lastcommand = command
            } else { dataCollection.add(line) }
        }

        if (commandFlag) {
            commandHandler.getCommands()[lastcommand]?.execute(dataCollection)
            dataCollection.clear()
        }

        console.addToHistory(name)
    }

    override fun execute(list: MutableList<String>) {
        if (list.isEmpty()) {
            console.printError("Не указан путь к файлу скрипта.")
            return
        }

        if (recursionDepth >= 3) {
            throw RuntimeException("Превышена допустимая глубина рекурсии при вызове execute_script!")
        }

        recursionDepth++
        try {
            val scriptFile = list[0]
            val lines: List<String>

            try {
                lines = File(scriptFile).readLines()
            } catch (e: FileNotFoundException) {
                console.printError("Файл '$scriptFile' не найден.")
                Thread.sleep(100)
                return
            }

            var lastCommand = ""
            val dataCollection = mutableListOf<String>()
            var commandFlag = false


            for (line in lines) {
                if (line.startsWith("\\") || line.isEmpty()) {
                    val command = line.drop(1).trim()

                    if (commandFlag) {
                        commandHandler.getCommands()[lastCommand]?.execute(dataCollection)
                        commandFlag = false
                        dataCollection.clear()
                    }

                    if (commandHandler.getCommands()[command]?.supportsDataCollection == true) {
                        commandFlag = true
                    } else {
                        commandHandler.getCommands()[command]?.execute()
                    }

                    lastCommand = command
                } else {
                    dataCollection.add(line)
                }
            }

            if (commandFlag) {
                commandHandler.getCommands()[lastCommand]?.execute(dataCollection)
                dataCollection.clear()
            }

        } finally { recursionDepth-- }
    }
}