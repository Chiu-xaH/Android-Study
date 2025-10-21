package answer

// 新接口
private interface Logger {
    fun log(message: String)
}

// 旧接口
private class OldLogger {
    fun log(msg: String) {
        println("OldLogger: $msg")
    }
}

private class LoggerAdapter(private val oldLogger: OldLogger) : Logger {
    override fun log(message: String) {
        oldLogger.log(message)
    }
}

private fun main() {
    val oldLogger = OldLogger()
    val logger = LoggerAdapter(oldLogger)
    logger.log("This is new log")
}
