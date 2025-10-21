package practice

private interface LightState {
    fun enter()
    fun switch(context : LightContext)
}


private class OffState : LightState {
    override fun enter() {
        println("灯灭")
    }

    override fun switch(context : LightContext) {
        context.setState(OnState())
    }
}

private class OnState : LightState {
    override fun enter() {
        println("灯亮")
    }

    override fun switch(context : LightContext) {
        context.setState(BrinkState())
    }
}

private class BrinkState : LightState {
    override fun enter() {
        println("灯闪烁")
    }

    override fun switch(context : LightContext) {
        context.setState(OffState())
    }
}

private class LightContext {
    private var state : LightState = OffState()

    fun switch() = state.switch(this)

    fun setState(target : LightState) {
        this.state = target
        state.enter()
    }
}

private fun main() {
    val lightContext = LightContext()
    repeat(4) {
        lightContext.switch()
    }
}