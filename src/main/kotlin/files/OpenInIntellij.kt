package ge.nika.files

import ge.nika.Config
import ge.nika.INTELLIJ_EXECUTABLE

fun openInIntellij(fileLocation: String) {
    Runtime.getRuntime()
        .exec("""${Config.intellijExecutable} $fileLocation""")
        .onExit()
        .get()
}