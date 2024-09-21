fun and(num1 : Int,num2 : Int,operation : (Int,Int) -> Int) : Int {
    val result = operation(num1,num2)
    return result
}
fun plus(num1 : Int,num2 : Int) : Int {
    return num2 + num1
}
fun minus(num1 : Int,num2 : Int) : Int {
    return num1 - num2
}
fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = and(num1,num2) {n1,n2 -> n1 + n2}
    println("$result1") 
}