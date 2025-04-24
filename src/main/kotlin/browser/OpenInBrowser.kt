package ge.nika.browser

import ge.nika.configuration.Config
import ge.nika.configuration.clArguments
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

fun randomUrl(): String =
    File(clArguments["urls"]!!).readLines().random()