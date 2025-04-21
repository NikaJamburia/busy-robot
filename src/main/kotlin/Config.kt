package ge.nika

import ge.nika.mouse.Coordinates
import java.util.*

object Config {
    val osName = System.getProperty("os.name").lowercase(Locale.ENGLISH)

    val intellijExecutable: String = when {
        osName.contains("windows") ->
            """C:\Users\nikaj\AppData\Local\Programs\IntelliJ IDEA Ultimate\bin\idea64.exe"""
        else -> error("Idk yet")
    }

    val browserCommand: String = """
        "C:\Program Files\Google\Chrome\Application\chrome.exe"
    """.trimIndent()

    val closeBrowserCommand: String = "taskkill /F /IM chrome.exe /T"

    val keyPressPauseRange = 50..100L

    val tempDirectory = """C:\Users\nikaj\AppData\Local\Temp\busy-robot\"""

    val screenDimensions = Coordinates(1920.0, 1080.0)
}