package ge.nika

val Number.minutes: Long
    get() = this.toLong() * 60000

val Number.seconds: Long
    get() = this.toLong() * 1000
