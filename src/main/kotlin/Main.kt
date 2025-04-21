package ge.nika

import ge.nika.mouse.Coordinates
import ge.nika.mouse.moveMouseSmoothly
import ge.nika.task.TimedTask.Companion.executeTask
import ge.nika.task.WriteCode
import java.awt.Robot

fun main() {

    val robot = Robot()

    robot.executeTask(WriteCode("""D:\dev\file-write\src"""), 5.seconds)
        .executeTask(WriteCode("""D:\dev\busy-robot\testFiles"""), 6.seconds)

    robot.moveMouseSmoothly(Coordinates(0.0, 0.0), Coordinates(1920.0, 1080.0))
        .thenMoveTo(700.0, 200.0)
        .thenWait(500)
        .thenMoveTo(346.0, 496.0)

}





