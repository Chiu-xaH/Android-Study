private object Singleton {
    var pc = "Lenovo"
}

private fun main() {
    println(Singleton.pc)
    Singleton.pc = "Hp"
    println(Singleton.pc)
}