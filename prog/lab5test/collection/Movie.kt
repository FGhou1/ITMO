package collection

import collection.Person
import collection.MpaaRating
import collection.MovieGenre
import collection.Coordinates
import java.util.Date

data class Movie(
    val id: Int,               // Не может быть меньше нуля
    val name: String,          // Не может быть null
    val coordinates: Coordinates,    // Не может быть null
    val creationDate: Date,    // Не может быть null
    val oscarsCount: Int,      // Не может быть меньше нуля
    val genre: MovieGenre,     // Не может быть null
    val mpaaRating: MpaaRating?, // Может быть null
    val director: Person?      // Может быть null
)