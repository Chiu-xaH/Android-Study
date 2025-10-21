package practice

private abstract class Handler {
    private var nextHandler : Handler? = null

    fun setNext(handler : Handler) : Handler {
        nextHandler = handler
        return handler
    }

    fun handle(msg : String) {
        if(process(msg)) {
            return
        }
        nextHandler?.handle(msg)
    }

    protected abstract fun process(msg : String) : Boolean
}

private class LogHandler : Handler() {
    override fun process(msg: String): Boolean {
        println("Log $msg")
        return false
    }
}

private class AuthHandler : Handler() {
    override fun process(msg: String): Boolean =
        if(msg.contains("token")) {
            println("Auth 验证成功")
            false
        } else {
            println("Auth 验证失败")
            true
        }
}

private class InnerHandler : Handler() {
    override fun process(msg: String): Boolean {
        println("Inner 处理内部请求")
        return true
    }
}


private fun main() {
    val handler = LogHandler()
    handler.setNext(AuthHandler()).setNext(InnerHandler())
    handler.handle("hello")
    handler.handle("hello?token")
}
