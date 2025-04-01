package main

import commands.*
import utils.*

fun main() {
    val console = StandardConsole()
    val collection = MovieCollection()
    val xmlReader = XMLreader(console)
    val commandHandler = CommandHandler()
    val movieCollection = xmlReader.read(console.getPath(), collection)

    commandHandler.register("help", Help(console, commandHandler))
    commandHandler.register("info", Info(console, movieCollection))
    commandHandler.register("show", Show(console, movieCollection))
    commandHandler.register("add", Add(console, movieCollection))
    commandHandler.register("update", Update(console, movieCollection))
    commandHandler.register("remove_by_id", RemoveByID(console, movieCollection))
    commandHandler.register("clear", Clear(console, movieCollection))
    commandHandler.register("save", Save(console, movieCollection))
    commandHandler.register("execute_script", ExecuteScript(console, commandHandler))
    commandHandler.register("exit", Exit(console))
    commandHandler.register("remove_lower", RemoveLower(console, movieCollection))
    commandHandler.register("remove_greater", RemoveGreater(console, movieCollection))
    commandHandler.register("history", History(console, commandHandler))
    commandHandler.register("remove_any_by_genre", RemmoveAnyByGenry(console, movieCollection))
    commandHandler.register("average_of_oscars_count", AverageOfOscarsCount(console, movieCollection))
    commandHandler.register("min_by_mpaa_rating", MinByMpaaRating(console, movieCollection))

    while (true) { commandHandler.getCommands()[console.readln().trim()]?.execute() } }
