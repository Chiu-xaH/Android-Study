package answer

// 饿汉
private object EagerSingleton {
    var pc = "Lenovo"
}
// 懒汉
private class LazySingleTon {
    var pc = "Lenovo"
    companion object {
        val instance by lazy { LazySingleTon() }
    }
}

private fun main() {
    println(EagerSingleton.pc)
    EagerSingleton.pc = "Hp"
    println(EagerSingleton.pc)
    println(LazySingleTon.instance.pc)
    LazySingleTon.instance.pc = "Hp"
    println(LazySingleTon.instance.pc)
}