package ge.nika.configuration

lateinit var clArguments: Map<String, String>

fun initCommandLineArgs(args: Array<String>) {
    clArguments = buildMap {
        args.forEach { arg ->
            check(arg.startsWith("--"))
            check(arg.contains("="))

            val (argName, argValue) = arg.split("=")
            put(
                argName.replace("--", ""),
                argValue
            )
        }
    }
}