package ge.nika.task

import ge.nika.*
import ge.nika.browser.closeBrowser
import ge.nika.browser.openInBrowser
import ge.nika.browser.randomUrl
import ge.nika.configuration.Config
import ge.nika.mouse.Coordinates
import ge.nika.mouse.MovementResult
import ge.nika.mouse.moveMouseSmoothly
import ge.nika.mouse.scrollSmoothly
import java.awt.Robot

class ReadRandomArticle : TimedTask() {

    override val name: String = this::class.simpleName ?: "UnnamedTask"
    private val url: String = randomUrl()

    override fun run(robot: Robot) {
        println("beee")
        openInBrowser(url)
        println("beee2")
        Thread.sleep(1.seconds)

        val readingStartPosition = robot.moveMouseSmoothly(
            from = upperLeftCorner,
            to = Coordinates(300.0, 300.0),
        )

        while(true) {
            val mouse = followLinesWithMouse(readingStartPosition, 1)
            robot.scrollSmoothly(3)
            mouse.thenMoveTo(readingStartPosition.lastMouseLocation)
        }
    }

    private fun followLinesWithMouse(startPosition: MovementResult, linesCount: Int): MovementResult {
        val startX = startPosition.lastMouseLocation.x
        val startY = startPosition.lastMouseLocation.y
        val lineHeight = 30

        val forwardTime = 6.seconds
        val returnTime = 100.milliseconds

        return (1..linesCount).fold(startPosition) { position, lineNumber ->
            position.thenMoveTo(Config.screenDimensions.x-300, position.lastMouseLocation.y, forwardTime)
                .thenMoveTo(startX, startY + (lineNumber * lineHeight), returnTime)
        }
    }

    override fun cleanUp(robot: Robot) {
        closeBrowser()
    }
}