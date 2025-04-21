package ge.nika.typing

import ge.nika.files.openInIntellij
import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.File

fun Robot.workOnFile(
    workingFileUrl: String,
    sourceUrl: String,
    pauseRange: LongRange
) {
    val srcFile = File(sourceUrl)
    srcFile.bufferedReader().use { reader ->
        openInIntellij(workingFileUrl)

        deleteFileContents()
        reader.readLines().forEach { line ->
            line.forEach { character ->
                keyPressesMap[character]
                    ?.let {
                        perform(it)
                        Thread.sleep(pauseRange.random())
                    }
                    ?: println("No keypress defined for char $character")
            }
            perform(KeyPress.enter())
            perform(KeyPress.home())
        }
    }
}

fun Robot.perform(keyPress: KeyPress) {
    if (keyPress.isShifted) {
        keyPress(KeyEvent.VK_SHIFT);
    }
    keyPress(keyPress.code);
    keyRelease(keyPress.code);
    if (keyPress.isShifted) {
        keyRelease(KeyEvent.VK_SHIFT);
    }
}

fun Robot.deleteFileContents() {
    keyPress(KeyEvent.VK_CONTROL)

    keyPress(KeyEvent.VK_A)
    keyRelease(KeyEvent.VK_A)

    keyRelease(KeyEvent.VK_CONTROL)

    keyPress(KeyEvent.VK_BACK_SPACE)
    keyRelease(KeyEvent.VK_BACK_SPACE)
}