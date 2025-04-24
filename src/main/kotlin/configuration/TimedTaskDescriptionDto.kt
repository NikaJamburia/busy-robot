package ge.nika.configuration

import ge.nika.hours
import ge.nika.milliseconds
import ge.nika.minutes
import ge.nika.seconds
import ge.nika.task.ReadRandomArticle
import ge.nika.task.TimedTask
import ge.nika.task.WriteCode
import kotlinx.serialization.Serializable

@Serializable
data class TimedTaskDescriptionDto(
    val name: String,
    val args: List<String>,
    val timeStr: String
) {
    val timeMillis: Long
        get() = when {
            timeStr.endsWith("h") -> timeStr.remove("h").toLong().hours
            timeStr.endsWith("m") -> timeStr.remove("m").toLong().minutes
            timeStr.endsWith("ms") -> timeStr.remove("ms").toLong().milliseconds
            timeStr.endsWith("s") -> timeStr.remove("s").toLong().seconds
            else -> error("Could not parse time: $timeStr")
        }

    private fun String.remove(subStr: String) = replace(subStr, "")

    fun toTimedTask(): TimedTask {
        return when(name) {
            WriteCode::class.simpleName -> WriteCode(args.first())
            ReadRandomArticle::class.simpleName -> ReadRandomArticle()
            else -> error("No time task found with name $name")
        }
    }
}