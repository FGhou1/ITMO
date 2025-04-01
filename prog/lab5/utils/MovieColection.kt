package utils

import core.Movie
import java.time.LocalDateTime
import java.util.LinkedHashSet

class MovieCollection {

    private val movies: LinkedHashSet<Movie> = LinkedHashSet()
    private val creationTime: LocalDateTime = LocalDateTime.now()

    fun getCreationTime() : LocalDateTime{
        return creationTime
    }

    fun getMovies(): LinkedHashSet<Movie> {
        return movies
    }
    /**
     * Добавление фильма с автоматической сортировкой по id
     */

    fun addMovie(console: StandardConsole, movie: Movie) {

        // Создаем временный список из текущих фильмов
        val sortedMovies = movies.toMutableList()

        // Проверяем, существует ли фильм с таким id
        if (sortedMovies.any { it.id == movie.id }) { console.printer("Фильм с id = ${movie.id} уже существует в коллекции.") ; return }

        // Добавляем новый фильм в список
        sortedMovies.add(movie)

        // Сортируем список по id
        sortedMovies.sortBy { it.id }

        // Перезаписываем LinkedHashSet по отсортированному списку
        movies.clear()
        movies.addAll(sortedMovies)

        console.printer("Фильм \"${movie.name}\" добавлен в коллекцию.")
    }

    fun removeMovie(console: StandardConsole, movie: Movie) {
        if (movies.remove(movie)) {
            console.printer("Фильм \"${movie.name}\" удален из коллекции.")
        } else {
            console.printer("Фильм \"${movie.name}\" не найден в коллекции.")
        }
    }
}
