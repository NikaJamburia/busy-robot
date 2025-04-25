package ge.nika.task

import ge.nika.configuration.Config
import ge.nika.files.copyFileContentsTo
import ge.nika.files.copyToTemp
import ge.nika.files.getJavaAndKotlinFilePaths
import ge.nika.typing.workOnFile
import java.awt.Robot
import java.io.File

class WriteCode(
    private val workingDir: String,
) : TimedTask() {

    private val tempToWorkingFiles: MutableMap<String, String> = mutableMapOf()

    override val name: String = "${this::class.simpleName}: $workingDir"

    override fun run(robot: Robot) {
        getJavaAndKotlinFilePaths(workingDir)
            .shuffled()
            .forEach {
                val tempUrl = it.copyToTemp()
                tempToWorkingFiles.put(tempUrl, it)

                robot.workOnFile(
                    workingFileUrl = it,
                    sourceUrl = tempUrl,
                    pauseRange = Config.keyPressPauseRange
                )
            }
    }

    override fun cleanUp(robot: Robot) {
        tempToWorkingFiles.forEach { (tmp, workingFile) ->
            tmp.copyFileContentsTo(workingFile)
            File(tmp).delete()
        }
    }
}