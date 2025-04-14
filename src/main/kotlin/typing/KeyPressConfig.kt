package ge.nika.typing

import java.awt.event.KeyEvent

val keyPressesMap =
    buildMap {
//        put('\n', KeyPress(KeyEvent.VK_ENTER,false));
//        put('\t', KeyPress(KeyEvent.VK_TAB,false));
        put('\r', KeyPress(KeyEvent.VK_HOME, false));
        put(' ', KeyPress(KeyEvent.VK_SPACE, false));
        put('!', KeyPress(KeyEvent.VK_1, true));
        put('"', KeyPress(KeyEvent.VK_QUOTE, true));
        put('#', KeyPress(KeyEvent.VK_3, true));
        put('$', KeyPress(KeyEvent.VK_4, true));
        put('%', KeyPress(KeyEvent.VK_5, true));
        put('&', KeyPress(KeyEvent.VK_7, true));
        put('\'', KeyPress(KeyEvent.VK_QUOTE, false));
        put('(', KeyPress(KeyEvent.VK_9, true));
        put(')', KeyPress(KeyEvent.VK_0, true));
        put('*', KeyPress(KeyEvent.VK_8, true));
        put('+', KeyPress(KeyEvent.VK_EQUALS, true));
        put(',', KeyPress(KeyEvent.VK_COMMA, false));
        put('-', KeyPress(KeyEvent.VK_MINUS, false));
        put('.', KeyPress(KeyEvent.VK_PERIOD, false));
        put('/', KeyPress(KeyEvent.VK_SLASH, false));

        put(':', KeyPress(KeyEvent.VK_SEMICOLON, true));
        put(';', KeyPress(KeyEvent.VK_SEMICOLON, false));
        put('<', KeyPress(KeyEvent.VK_COMMA, true));
        put('=', KeyPress(KeyEvent.VK_EQUALS, false));
        put('>', KeyPress(KeyEvent.VK_PERIOD, true));
        put('?', KeyPress(KeyEvent.VK_SLASH, true));
        put('@', KeyPress(KeyEvent.VK_2, true));

        put('[', KeyPress(KeyEvent.VK_OPEN_BRACKET, false));
        put('\\', KeyPress(KeyEvent.VK_BACK_SLASH, false));
        put(']', KeyPress(KeyEvent.VK_CLOSE_BRACKET, false));
        put('^', KeyPress(KeyEvent.VK_6, true));
        put('_', KeyPress(KeyEvent.VK_MINUS, true));
        put('`', KeyPress(KeyEvent.VK_BACK_QUOTE, false));

        put('{', KeyPress(KeyEvent.VK_OPEN_BRACKET, true));
        put('|', KeyPress(KeyEvent.VK_BACK_SLASH, true));
        put('}', KeyPress(KeyEvent.VK_CLOSE_BRACKET, true));
        put('~', KeyPress(KeyEvent.VK_BACK_QUOTE, true));


        ('0'.code..'9'.code).forEach {
            put(it.toChar(), KeyPress(it, false));
        }

        ('A'.code..'Z'.code).forEach {
            put(it.toChar(), KeyPress(it, true));
        }

        ('A'.code..'Z'.code).forEach {
            val key = (it + ('a'.code - 'A'.code)).toChar()
            put(key, KeyPress(it, false));
        }

    }