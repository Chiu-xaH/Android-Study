package com.example.helloworld

class Person {
    var name = ""
    var age = 0
    fun eat() {
        println(name + "is eating. + He is " + age + " years old")
    }
}
fun main() {
    val p = Person()
    p.name = "Jack"
    p.age = 19
    p.eat()
}