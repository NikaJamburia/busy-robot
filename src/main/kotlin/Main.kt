package ge.nika

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.decodeFromStream
import ge.nika.configuration.Config
import ge.nika.configuration.TimedTaskDescriptionDto
import ge.nika.configuration.clArguments
import ge.nika.configuration.initCommandLineArgs
import ge.nika.task.TimedTask.Companion.executeTask
import java.awt.Robot
import java.io.File

fun main(args: Array<String>) {

    initCommandLineArgs(args)
    Config.initFromClArgs()

    val robot = Robot()

    getConfiguredTasks().forEach { taskDto ->
        robot.executeTask(taskDto.toTimedTask(), taskDto.timeMillis)
    }
}

private fun getConfiguredTasks(): List<TimedTaskDescriptionDto> {
    return File(clArguments["tasksFile"]!!).inputStream().use {
        Yaml.default.decodeFromStream<List<TimedTaskDescriptionDto>>(it)
    }
}





