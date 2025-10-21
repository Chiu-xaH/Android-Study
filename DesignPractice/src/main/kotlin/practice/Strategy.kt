package practice

import java.util.PriorityQueue

private interface Max {
    fun getMaxValue(list : List<Int>) : Int
}

private class Max1() : Max {
    override fun getMaxValue(list: List<Int>): Int {
        var max = Int.MIN_VALUE
        list.forEach { item ->
            if(item > max) {
                max = item
            }
        }
        return max
    }
}

private class Max2() : Max {
    override fun getMaxValue(list: List<Int>): Int {
        val heap = PriorityQueue<Int>(compareByDescending { it })
        list.forEach { item ->
            heap.add(item)
        }
        return heap.peek()
    }
}

private class MaxStrategy(private var strategy : Max) {
    fun set(target : Max) {
        strategy = target
    }
    fun get() : Max {
        return strategy
    }
}

private fun main() {
    val l = listOf<Int>(2,5,8,-1,7)
    val s = MaxStrategy(Max1())
    println("S1 ${s.get().getMaxValue(l)}")
    s.set(Max2())
    println("S2 ${s.get().getMaxValue(l)}")
}