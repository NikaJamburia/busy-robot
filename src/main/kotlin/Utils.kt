package ge.nika

import ge.nika.configuration.Config
import ge.nika.mouse.Coordinates

val Number.minutes: Long
    get() = this.toLong() * 60000

val Number.seconds: Long
    get() = this.toLong() * 1000

val Number.milliseconds: Long
    get() = this.toLong()

val Number.hours: Long
    get() = (this.toLong() * 60).minutes

val screenCenter: Coordinates
    get() = Coordinates(
        Config.screenDimensions.x / 2,
        Config.screenDimensions.y / 2,
    )

val upperLeftCorner: Coordinates
    get() = Coordinates(0.0, 0.0)
