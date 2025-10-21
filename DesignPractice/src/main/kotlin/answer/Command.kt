package answer

private interface Command {
    fun execute()
    fun undo()
}

private class Light {
    fun turnOn() = println("灯亮了")
    fun turnOff() = println("灯灭了")
}

private class LightOnCommand(private val light: Light) : Command {
    override fun execute() = light.turnOn()
    override fun undo() = light.turnOff()
}

private class LightOffCommand(private val light: Light) : Command {
    override fun execute() = light.turnOff()
    override fun undo() = light.turnOn()
}


private class RemoteControl {
    private val history = mutableListOf<Command>()

    fun pressButton(command: Command) {
        command.execute()
        history.add(command)
    }

    fun pressUndo() {
        if (history.isNotEmpty()) {
            val last = history.removeLast()
            last.undo()
        }
    }
}

private fun main() {
    val light = Light()
    val remote = RemoteControl()

    val onCommand = LightOnCommand(light)
    val offCommand = LightOffCommand(light)

    remote.pressButton(onCommand)
    remote.pressButton(offCommand)
    remote.pressUndo()
}

