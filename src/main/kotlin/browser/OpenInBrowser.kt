package ge.nika.browser

import ge.nika.Config
import ge.nika.task.TimedTask
import java.io.File

fun openInBrowser(url: String) {
    Runtime.getRuntime()
        .exec("""${Config.browserCommand} "$url" """)
        .onExit()
        .get()
}

fun closeBrowser() {
    Runtime.getRuntime()
        .exec(Config.closeBrowserCommand)
        .onExit()
        .get()
}

fun randomUrl(): String {
    return File(
        TimedTask::class.java.classLoader.getResource("urls.txt")!!.toURI()
    ).readLines().random()
}