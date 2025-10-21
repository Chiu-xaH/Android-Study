package practice
// 复盘
private interface Coffee {
    fun description() : String
}

private class MilkCoffee() : Coffee {
    override fun description() = "MilkCoffee Cost $5"
}

private class FruitCoffee() : Coffee {
    override fun description()  = "FruitCoffee Cost $7"
}

private open class CoffeeDecorator(private val coffee : Coffee) : Coffee {
    override fun description() = coffee.description()
}

private class MilkCoffeeDecorator(coffee : Coffee) : CoffeeDecorator(coffee) {
    override fun description() : String {
        return  "${super.description()} Added Milk"
    }
}

private class FruitCoffeeDecorator(coffee : Coffee) : CoffeeDecorator(coffee) {
    override fun description() : String {
        return  "${super.description()} Added Fruit"
    }
}
private fun main() {
    val fc = FruitCoffee()
    val mc = MilkCoffee()
    println(FruitCoffeeDecorator(mc).description())
    println(MilkCoffeeDecorator(fc).description())
}