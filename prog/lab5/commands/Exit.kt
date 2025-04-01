package commands

import kotlin.system.exitProcess
import utils.StandardConsole

class Exit(private val console: StandardConsole
) : Command(name = "exit", description = "завершить программу (без сохранения в файл)") {

    override var supportsDataCollection: Boolean = false

    override fun execute() { console.printer("Все, пока! Программа закончена ( -_-)") ;  }

    override fun execute(list: MutableList<String>) { exitProcess(0) }
}