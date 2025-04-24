package ge.nika.args

fun parseCommandLineArgs(args: Array<String>): Map<String, String> {
    return buildMap {
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