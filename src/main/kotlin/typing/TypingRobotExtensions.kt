package ge.nika.typing

import ge.nika.files.openInIntellij
import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.File

fun Robot.workOnFile(srcFileUrl: String, pauseRange: LongRange) {
    val srcFile = File(srcFileUrl)
    srcFile.bufferedReader().use { reader ->
        openInIntellij("""D:\dev\file-write\files\dest.kt""")

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
            mouseMove(700, 500)
            mouseMove(700, 200)
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