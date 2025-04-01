package utils

import java.io.File
import java.util.Scanner

/**
 * Для ввода команд и вывода результата
 * */

class StandardConsole{

    init {
        val messages = Messages()
        printer(messages.greetings())

        filePath = find()

    }

    companion object {
        private const val PROMT_QUESTION = "# "
        private const val PROMT_ANSWER = "|>"
        private lateinit var filePath: String
        private var fileScanner: Scanner? = null
        private val inputScanner = Scanner(System.`in`)
        private val commandHistory: MutableList<String> = mutableListOf()

    }

    fun splitStringByNewLine(input: String): List<String> { return input.split("\n") }

    fun printer(message: String) { splitStringByNewLine(message).forEach{ println("$PROMT_QUESTION $it") }}

    fun printError(message: String) { System.err.println("$PROMT_QUESTION $message")}

    fun readln(): String { print(" $PROMT_ANSWER ") ; return (fileScanner ?: inputScanner).nextLine()}

    fun timer(messag: String){ repeat(5) { Thread.sleep(600); if (it == 0) print("$PROMT_QUESTION $messag") else print(" .") } ; print("\n")}

    fun getPath(): String { return filePath }


    fun getCommandHistory(): List<String> { return commandHistory }

    fun addToHistory(command: String) { commandHistory.add(command) }

    fun find() : String {

        printer("Загрузить своой файл? или создать новый? (yes/no): ")

        while (true){

            val userInput = readln().trim().lowercase()

            if (userInput == "y" || userInput == "n" || userInput == "yes" || userInput == "no" ) {
                when (userInput) {

                    "y", "yes" -> { return findPath() }

                    "n", "no" -> {
                        timer("Загрузка файла")
                        val file = File("/home/maxim/IdeaProjects/lab5/src/products/newFile.xml")
                        file.createNewFile()
                        file.writeText("<root>\n</root>")

                        return "/home/maxim/IdeaProjects/lab5/src/products/newFile.xml"
                    }
                }
            } else { printError("Пожалуйста, введите корректное значение: 'yes' или 'no'.") ; Thread.sleep(100) }
        }
    }

    fun findPath() : String {
        while (true) {
            printer("Введите путь к файлу: ")

            val userInput = readln().trim()

            if (userInput.isNotEmpty()) {

                val file = File(userInput)
                if (file.exists() && file.canRead()) {
                    timer("Чтение файла")
                    return userInput

                } else { printError("Файл недоступен для чтения. Проверьте права доступа.") }
            } else { printError("Пожалуйста, введите корректный путь к файлу.") }
        }

    }
}

