package ge.nika.typing

import java.awt.event.KeyEvent

data class KeyPress(
    val code: Int,
    val isShifted: Boolean
) {
    companion object {
        fun enter() = KeyPress(KeyEvent.VK_ENTER, false)
        fun home() = KeyPress(KeyEvent.VK_HOME, false)
    }
}