package ge.nika.mouse

data class Coordinates(
    val x: Double,
    val y: Double,
) {
    fun moveTowards(vector: Coordinates, timeDelta: Double): Coordinates {
        return Coordinates(
            x + (vector.x * timeDelta),
            y + (vector.y * timeDelta),
        )
    }
}