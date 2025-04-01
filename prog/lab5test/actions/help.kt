fun help() {
    println("""
        Доступные команды:
        help : вывести справку по доступным командам
        info : вывести информацию о коллекции
        show : вывести все элементы коллекции
        add {element} : добавить новый элемент в коллекцию
        update id {element} : обновить элемент по ID
        remove_by_id id : удалить элемент по ID
        clear : очистить коллекцию
        save : сохранить коллекцию в файл
        execute_script file_name : выполнить скрипт из файла
        exit : завершить программу
        remove_greater {element} : удалить элементы больше заданного
        remove_lower {element} : удалить элементы меньше заданного
        history : вывести последние 14 команд
        remove_any_by_genre genre : удалить элемент по жанру
        average_of_oscars_count : вывести среднее значение oscarsCount
        min_by_mpaa_rating : вывести объект с минимальным mpaaRating
    """.trimIndent())
}