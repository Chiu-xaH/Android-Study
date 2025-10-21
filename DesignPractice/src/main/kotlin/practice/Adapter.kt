package practice


private interface MyLogger {
    fun log(msg : String)
}

private class MyOldLogger {
    fun log(msg : String) {
        println("Print from OldLogger : $msg")
    }
}

private class NewLogAdapter(private val lodLogger : MyOldLogger) : MyLogger {
    override fun log(msg: String) {
        lodLogger.log(msg)
    }
}

private fun main() {
    val old = MyOldLogger()
    val new = NewLogAdapter(old)
    new.log("hello")
}
