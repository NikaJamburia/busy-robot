package ge.nika

import ge.nika.args.parseCommandLineArgs
import ge.nika.task.ReadRandomArticle
import ge.nika.task.TimedTask.Companion.executeTask
import ge.nika.task.WriteCode
import java.awt.Robot

fun main(args: Array<String>) {

    val argsMap = parseCommandLineArgs(args)

    Config.initFromYamlFile(argsMap["config"]!!)

    Robot()
        .executeTask(WriteCode("""D:\dev\file-write\src"""), 1.hours)
        .executeTask(ReadRandomArticle(), 15.minutes)
        .executeTask(WriteCode("""D:\dev\busy-robot\testFiles"""), 20.minutes)

}





