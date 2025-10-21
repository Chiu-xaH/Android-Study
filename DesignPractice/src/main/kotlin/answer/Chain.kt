package answer

private abstract class Handler {
    private var next: Handler? = null

    fun setNext(handler: Handler): Handler {
        next = handler
        return handler
    }

    fun handle(request: String) {
        if (process(request)) return
        next?.handle(request)
    }

    // 返回 true 表示请求已被处理
    protected abstract fun process(request: String): Boolean
}

private class LogHandler : Handler() {
    override fun process(request: String): Boolean {
        println("日志：收到请求 -> $request")
        return false  // 不处理，继续往下传
    }
}

private class AuthHandler : Handler() {
    override fun process(request: String): Boolean {
        return if (request.contains("token")) {
            println("权限校验通过")
            false // 继续传递
        } else {
            println("权限校验失败，拒绝请求")
            true  // 终止链
        }
    }
}

private class BusinessHandler : Handler() {
    override fun process(request: String): Boolean {
        println("执行业务逻辑：处理请求 $request")
        return true // 处理完成，链结束
    }
}

private fun main() {
    // 构建责任链：日志 → 权限 → 业务
    val chain = LogHandler()
    chain.setNext(AuthHandler())
        .setNext(BusinessHandler())

    println("\n--- 请求1（无token） ---")
    chain.handle("getUserInfo")

    println("\n--- 请求2（带token） ---")
    chain.handle("getUserInfo?token=123")
}
