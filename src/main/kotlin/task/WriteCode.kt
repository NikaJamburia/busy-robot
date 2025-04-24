package ge.nika.task

import ge.nika.configuration.Config
import ge.nika.files.copyToTemp
import ge.nika.files.getJavaAndKotlinFilePaths
import ge.nika.typing.workOnFile
import java.awt.Robot
import java.io.File

class WriteCode(
    private val workingDir: String,
) : TimedTask() {

    private val tempFiles = mutableListOf<String>()

    override val name: String = "${this::class.simpleName}: $workingDir"

    override fun run(robot: Robot) {
        getJavaAndKotlinFilePaths(workingDir)
            .shuffled()
            .forEach {
                val tempUrl = it.copyToTemp()
                tempFiles.add(tempUrl)

                robot.workOnFile(
                    workingFileUrl = it,
                    sourceUrl = tempUrl,
                    pauseRange = Config.keyPressPauseRange
                )
            }
    }

    override fun cleanUp(robot: Robot) {
        tempFiles.forEach {
            File(it).delete()
        }
    }
}