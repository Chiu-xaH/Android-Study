
fun main() {
    val s = "Hello"
    val finalStr = s.apply {
        plus(" Added")
    }
    println(finalStr)
    println(s)
}