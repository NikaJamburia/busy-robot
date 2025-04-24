package ge.nika.files

import ge.nika.configuration.Config

fun openInIntellij(fileLocation: String) {
    Runtime.getRuntime()
        .exec("""${Config.intellijExecutable} $fileLocation""")
        .onExit()
        .get()
}