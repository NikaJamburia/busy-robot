package ge.nika

import ge.nika.configuration.Config
import ge.nika.configuration.getConfiguredTasks
import ge.nika.configuration.initCommandLineArgs
import ge.nika.configuration.setup
import ge.nika.task.TimedTask.Companion.executeTask
import java.awt.Robot
import java.io.File

fun main(args: Array<String>) {

    setup(args)

    val robot = Robot()

    getConfiguredTasks().forEach { taskDto ->
        robot.executeTask(taskDto.toTimedTask(), taskDto.timeMillis)
    }
}





