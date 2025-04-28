package ge.nika.configuration

import java.io.File

fun setup(args: Array<String>) {
    initCommandLineArgs(args)
    Config.initFromClArgs()

    clearTempDirectory()
}

fun clearTempDirectory() {
    val tempDirectory = File(Config.tempDirectory)

    check(tempDirectory.isDirectory) {
        "Invalid temp Directory!"
    }
    println("Clearing temp directory")
    tempDirectory.listFiles()?.forEach { it.delete() }
}