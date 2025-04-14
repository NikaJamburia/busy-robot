package ge.nika.mouse

import java.awt.Robot
import kotlin.math.min

fun Robot.moveMouseSmoothly(from: Coordinates, to: Coordinates): MovementResult {
    val targetTime = 100.toDouble()
    val timeInterval: Long = 9

    val vector = Coordinates(to.x - from.x, to.y - from.y)

    val path = buildList {
        var currentTime = 0L
        while (currentTime <= targetTime) {
            val timeDelta = min(1.0, currentTime / targetTime)
            add(from.moveTowards(vector, timeDelta))
            currentTime += timeInterval
        }
    }

    path
        .asSequence()
        .take(10_000)
        .forEach {
            moveMouseTo(it)
            Thread.sleep(timeInterval)
        }

    return MovementResult(this, to)
}

fun Robot.moveMouseTo(c: Coordinates) = mouseMove(c.x.toInt(), c.y.toInt())