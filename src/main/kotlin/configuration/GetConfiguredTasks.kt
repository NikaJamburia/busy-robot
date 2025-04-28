package ge.nika.configuration

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.decodeFromStream
import java.io.File

fun getConfiguredTasks(): List<TimedTaskDescriptionDto> {
    return File(clArguments["tasksFile"]!!).inputStream().use {
        Yaml.Companion.default.decodeFromStream<List<TimedTaskDescriptionDto>>(it)
    }
}