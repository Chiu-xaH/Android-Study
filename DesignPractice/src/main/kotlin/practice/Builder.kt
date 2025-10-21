package practice

private class MyComputer private constructor(
    val cpu : String,
    val memory : String,
    val oem : String,
) {
    class Builder {
        private var cpu = "Intel"
        private var memory = "16GB"
        private var oem = "Microsoft"
        fun setCpu(cpu : String) {
           this.cpu = cpu
        }
        fun setMemory(memory : String) {
            this.memory = memory
        }
        fun setOem(oem : String) {
            this.oem = oem
        }
        fun build(): MyComputer {
            return MyComputer(this.cpu,this.memory,this.oem)
        }
    }
}

private fun main() {
    val computer = MyComputer.Builder().apply {
        setCpu("i5-13th")
        setMemory("16GB")
        setOem("Lenovo")
    }.build()
    println(
        with(computer) {
            "$cpu $memory $oem"
        }
    )
}