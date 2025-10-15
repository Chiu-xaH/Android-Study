private abstract class Computer(private val name: String) {
    fun create() {
        println("Created ${this.name} Computer")
    }
}

private interface ComputerFactory {
    fun createComputer(): Computer
}

private class LenovoComputer : Computer("Lenovo")

private class LenovoFactory : ComputerFactory {
    override fun createComputer(): Computer = LenovoComputer()
}

private class HpComputer : Computer("Hp")

private class HpFactory : ComputerFactory {
    override fun createComputer(): Computer = HpComputer()
}

private fun main() {
    val factory: ComputerFactory = LenovoFactory()
    val computer = factory.createComputer()
    computer.create()
}

