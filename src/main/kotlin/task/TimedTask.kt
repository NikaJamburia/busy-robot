package ge.nika.task

import java.awt.Robot
import kotlin.concurrent.thread

abstract class TimedTask {

    protected abstract val name: String
    protected abstract fun run(robot: Robot)
    protected abstract fun cleanUp(robot: Robot)

    fun executeFor(forTime: Long, robot: Robot): Robot {
        val runnerThread = thread {
            try {
                println("Performing task $name")
                run(robot)
            } catch (ie: InterruptedException) {
                println("Task $name interrupted")
            }
            finally {
                println("Task $name performing cleanup")
                cleanUp(robot)
            }
        }

        runnerThread.join(forTime)
        println("Interrupting task $name. $forTime passed.")

        if (runnerThread.isAlive) {
            runnerThread.interrupt()
        }

        return robot
    }

    companion object {
        fun Robot.executeTask(task: TimedTask, forMilliseconds: Long): Robot =
            task.executeFor(forMilliseconds, this)
    }
}
