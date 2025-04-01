package core

import java.util.Date

data class Movie(
    val id: Int,
    val name: String,
    val coordinates: Coordinates,
    val creationDate: Date,
    val oscarsCount: Int,
    val genre: MovieGenre,
    val mpaaRating: MpaaRating?, // Может быть null
    val director: Person?      // Может быть null
)