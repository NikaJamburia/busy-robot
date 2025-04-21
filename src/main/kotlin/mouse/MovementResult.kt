package ge.nika.mouse

import java.awt.Robot

data class MovementResult(
    val robot: Robot,
    val lastMouseLocation: Coordinates,
    val jitter: Int,
    val targetTime: Double,
) {
    fun thenMoveTo(x: Number, y: Number, newTargetTime: Number = targetTime): MovementResult =
        thenMoveTo(Coordinates(x.toDouble(), y.toDouble()), newTargetTime)

    fun thenMoveTo(c: Coordinates, newTargetTime: Number = targetTime): MovementResult =
        robot.moveMouseSmoothly(
            from = lastMouseLocation,
            to = c,
            jitter = jitter,
            targetTime = newTargetTime.toDouble(),
        )

    fun thenIncrementPosition(x: Number, y: Number, newTargetTime: Number = targetTime): MovementResult =
        robot.moveMouseSmoothly(
            from = lastMouseLocation,
            to = Coordinates(
                x = lastMouseLocation.x + x.toDouble(),
                y = lastMouseLocation.y + y.toDouble()
            ),
            jitter = jitter,
            targetTime = newTargetTime.toDouble(),
        )

    fun thenWait(ms: Long): MovementResult {
        Thread.sleep(ms)
        return this
    }
}