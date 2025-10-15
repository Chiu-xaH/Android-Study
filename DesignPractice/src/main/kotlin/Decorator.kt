private interface Coffee {
    fun cost(): Double
    fun description(): String
}

private class SimpleCoffee : Coffee {
    override fun cost() = 5.0
    override fun description() = "普通咖啡"
}

private open class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double = coffee.cost()
    override fun description(): String = coffee.description()
}

private class MilkDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double = super.cost() + 2.0
    override fun description(): String = super.description() + " + 牛奶"
}

private class SugarDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double = super.cost() + 1.0
    override fun description(): String = super.description() + " + 糖"
}

private fun main() {
    var coffee: Coffee = SimpleCoffee()
    println("${coffee.description()} 价格: ${coffee.cost()}")

    coffee = MilkDecorator(coffee) // 加牛奶
    println("${coffee.description()} 价格: ${coffee.cost()}")

    coffee = SugarDecorator(coffee) // 再加糖
    println("${coffee.description()} 价格: ${coffee.cost()}")
}
