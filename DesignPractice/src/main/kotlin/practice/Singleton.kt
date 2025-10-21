package practice

private object EagerSingleton {
    var oem = "Lenovo"
}

private class LazySingleTon {
    companion object {
        val instance by lazy { LazySingleTon() }
    }
    var oem  = "Lenovo"
}

private fun main() {
    println(EagerSingleton.oem)
    EagerSingleton.oem = "Hp"
    println(EagerSingleton.oem)

    println(LazySingleTon.instance.oem)
    LazySingleTon.instance.oem = "Hp"
    println(LazySingleTon.instance.oem)
}