package ge.nika

import java.util.*

object Config {
    val osName = System.getProperty("os.name").lowercase(Locale.ENGLISH)

    val intellijExecutable: String = when {
        osName.contains("windows") ->
            """C:\Users\nikaj\AppData\Local\Programs\IntelliJ IDEA Ultimate\bin\idea64.exe"""
        else -> error("Idk yet")
    }

    val keyPressPauseRange = 50..100L

    val tempDirectory = """C:\Users\nikaj\AppData\Local\Temp\busy-robot\"""
}