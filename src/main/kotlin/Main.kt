package ge.nika

import ge.nika.mouse.Coordinates
import ge.nika.mouse.moveMouseSmoothly
import ge.nika.typing.workOnFile
import java.awt.Robot

fun main() {
    val robot = Robot()

    robot.moveMouseSmoothly(Coordinates(0.0, 0.0), Coordinates(1920.0, 1080.0))
        .thenTo(700.0, 200.0)
        .thenTo(346.0, 496.0)

    robot.workOnFile(
        srcFileUrl = """D:\dev\file-write\files\src.kt""",
        pauseRange = Config.keyPressPauseRange
    )
}





