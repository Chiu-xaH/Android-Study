package practice

private abstract class Computer(private val name : String) {
    fun create() {
        println("Computer $name")
    }
}
private interface ComputerFactory {
    fun createComputer() : Computer
}

private class LenovoComputer : Computer("Lenovo")
private class HpComputer : Computer("Hp")

private class LenovoComputerFactory : ComputerFactory {
    override fun createComputer() = LenovoComputer()
}

private class HpComputerFactory : ComputerFactory {
    override fun createComputer() = HpComputer()
}

private fun main() {
    val hp = HpComputerFactory().createComputer()
    val lenovo = LenovoComputerFactory().createComputer()
    hp.create()
    lenovo.create()
}