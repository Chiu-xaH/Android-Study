package practice

private interface Command {
    fun execute()
    fun undo()
}
private class Light {
    fun turnOn() = println("开灯了")
    fun turnOff() = println("关灯了")
    fun turnToBlink() = println("闪烁")
}

private class LightOnCommand(private val light : Light) : Command {
    override fun execute() = light.turnOn()
    override fun undo() = light.turnOff()
}

private class LightBlinkCommand(private val light : Light) : Command {
    override fun execute() = light.turnToBlink()
    override fun undo() = light.turnOn()
}

private class LightOffCommand(private val light : Light) : Command {
    override fun execute() = light.turnOff()
    override fun undo() = light.turnOn()
}


private class LightController(var command : Command) {
    private val commands = mutableListOf<Command>()

    fun pressButton() {
        command.execute()
        commands.add(command)
    }
    fun undo() {
        if(commands.isEmpty()) {
            return
        }
        commands.removeLast().undo()
    }
}

private fun main() {
    val light = Light()
    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)
    val lightBlinkCommand = LightBlinkCommand(light)

    val controller = LightController(lightOnCommand)
    controller.pressButton()
    controller.undo()
    controller.command = lightBlinkCommand
    controller.pressButton()
    controller.undo()
}


