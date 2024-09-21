package com.example.myapplication

open class Person(val name: String, val age: Int){
    fun eat() {
        println(name + " is eating.  He is " + age + " years old.")
    }
}
//fun main() {
    //val cellphone1 = Cellphone("Samsung", 1299.99)
    //val cellphone2 = Cellphone("Samsung", 1299.99)
    //println(cellphone1)
    //println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
//}
//fun doStudy(study:Study) {
    //study.readBooks()
    //study.doHomework()
//}

fun main() {
    val list = listOf("Apple","Banana","Orange","Pear")
    //val maxLengthFruit = list.maxBy { it.length }
    val LowerCase = list.map {it.toLowerCase()}
    for (fruit in LowerCase) {
        println(fruit)
    }
    println("max length fruit is " + LowerCase)
}
