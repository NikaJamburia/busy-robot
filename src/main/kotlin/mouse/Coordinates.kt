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

    fun applyJitter(jitter: Int): Coordinates {
        if (jitter <= 0) {
            return this
        } else {
            val randomJitter = (-jitter..jitter).random()
            return Coordinates(x + randomJitter, y + randomJitter)
        }
    }
}