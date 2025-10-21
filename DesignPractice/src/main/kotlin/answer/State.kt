package answer

private interface LightState {
    fun onEnter()          // 进入状态时
    fun pressSwitch(context: LightContext)
}

private class LightContext {
    private var state: LightState = OffState()

    fun setState(newState: LightState) {
        state = newState
        state.onEnter()
    }

    fun pressSwitch() {
        state.pressSwitch(this)
    }
}

private class OffState : LightState {
    override fun onEnter() = println("当前状态：关灯")
    override fun pressSwitch(context: LightContext) {
        println("打开灯")
        context.setState(OnState())
    }
}

private class OnState : LightState {
    override fun onEnter() = println("当前状态：开灯")
    override fun pressSwitch(context: LightContext) {
        println("进入闪烁模式")
        context.setState(BlinkState())
    }
}

private class BlinkState : LightState {
    override fun onEnter() = println("当前状态：闪烁模式")
    override fun pressSwitch(context: LightContext) {
        println("关闭灯")
        context.setState(OffState())
    }
}

private fun main() {
    val light = LightContext()

    repeat(5) {
        light.pressSwitch()
    }
}
