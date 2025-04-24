package ge.nika

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.decodeFromStream
import ge.nika.configuration.Config
import ge.nika.configuration.TimedTaskDescriptionDto
import ge.nika.configuration.parseCommandLineArgs
import ge.nika.task.TimedTask.Companion.executeTask
import java.awt.Robot
import java.io.File

fun main(args: Array<String>) {

    val argsMap = parseCommandLineArgs(args)

    Config.initFromYamlFile(argsMap["config"]!!)

    val robot = Robot()

    getTasksFromFile(argsMap["tasksFile"]!!).forEach { taskDto ->
        robot.executeTask(taskDto.toTimedTask(), taskDto.timeMillis)
    }
}

private fun getTasksFromFile(fileName: String): List<TimedTaskDescriptionDto> {
    return File(fileName).inputStream().use {
        Yaml.default.decodeFromStream<List<TimedTaskDescriptionDto>>(it)
    }
}





