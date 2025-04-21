package ge.nika.mouse

import java.awt.Robot

data class MovementResult(
    val robot: Robot,
    val lastMouseLocation: Coordinates
) {
    fun thenMoveTo(x: Number, y: Number): MovementResult =
        robot.moveMouseSmoothly(lastMouseLocation, Coordinates(x.toDouble(), y.toDouble()))

    fun thenWait(ms: Long): MovementResult {
        Thread.sleep(ms)
        return this
    }
}