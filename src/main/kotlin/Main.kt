package ge.nika

import ge.nika.task.ReadRandomArticle
import ge.nika.task.TimedTask.Companion.executeTask
import ge.nika.task.WriteCode
import java.awt.Robot

fun main(args: Array<String>) {

    Config.initFromYamlFile(args.first())

    Robot()
        .executeTask(WriteCode("""D:\dev\file-write\src"""), 1.hours)
        .executeTask(ReadRandomArticle(), 15.minutes)
        .executeTask(WriteCode("""D:\dev\busy-robot\testFiles"""), 20.minutes)

}





