package ge.nika.mouse

import java.awt.Robot
import kotlin.math.min

fun Robot.scrollSmoothly(value: Int) {
    repeat(value) {
        mouseWheel(1)
        Thread.sleep(50)
    }
}

fun Robot.moveMouseSmoothly(
    from: Coordinates,
    to: Coordinates,
    jitter: Int = 0,
    targetTime: Double = 100.0,
): MovementResult {
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
        .map { it.applyJitter(jitter) }
        .take(10_000)
        .forEach {
            moveMouseTo(it)
            Thread.sleep(timeInterval)
        }

    return MovementResult(
        robot = this,
        lastMouseLocation = to,
        jitter = jitter,
        targetTime = targetTime,
    )
}

fun Robot.moveMouseTo(c: Coordinates) = mouseMove(c.x.toInt(), c.y.toInt())