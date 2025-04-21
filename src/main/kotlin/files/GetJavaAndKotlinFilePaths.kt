package ge.nika.files

import ge.nika.Config
import java.io.File

fun getJavaAndKotlinFilePaths(directory: String): List<String> {
    return getFileNames(File(directory))
        .filter { it.endsWith(".kt") || it.endsWith(".java") }
}

fun String.copyToTemp(): String {
    val fileToToCopy = File(this)
    val tempFile = File("${Config.tempDirectory}/${System.currentTimeMillis()}-${fileToToCopy.name}")
    tempFile.createNewFile()

    tempFile.bufferedWriter().use { writer ->
        fileToToCopy.useLines { lines ->
            lines.forEach { line ->
                writer.write(line)
                writer.newLine()
            }
        }
    }
    return tempFile.absolutePath
}

private fun getFileNames(directory: File): List<String> {
    check(directory.isDirectory)

    return directory.listFiles()?.flatMap {
        if (it.isDirectory) {
            getFileNames(it)
        } else {
            listOf(it.absolutePath)
        }
    } ?: emptyList()
}