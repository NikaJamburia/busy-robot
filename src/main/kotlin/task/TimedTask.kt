package ge.nika.task

import java.awt.Robot
import kotlin.concurrent.thread

abstract class TimedTask {

    protected abstract val name: String
    protected abstract fun run(robot: Robot)
    protected abstract fun cleanUp(robot: Robot)

    private lateinit var runnerThread: Thread

    fun executeFor(forTime: Long, robot: Robot): Robot {
        val startTime = System.currentTimeMillis()
        runnerThread = thread {
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

        if (runnerThread.isAlive) {
            println("Interrupting task $name. $forTime passed.")
            runnerThread.interrupt()
        } else {
            println("Task $name finished in ${System.currentTimeMillis() - startTime} ms")
        }
        return robot
    }

    fun cancel() {
        runnerThread.interrupt()
    }

    companion object {
        fun Robot.executeTask(task: TimedTask, forMilliseconds: Long): Robot =
            task.executeFor(forMilliseconds, this)
    }
}
