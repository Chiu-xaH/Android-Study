private interface SortStrategy {
    fun sort(data: List<Int>): List<Int>
}

private class BubbleSortStrategy : SortStrategy {
    override fun sort(data: List<Int>): List<Int> {
        val list = data.toMutableList()
        for (i in list.indices) {
            for (j in 0..<list.size - i - 1) {
                if (list[j] > list[j + 1]) {
                    val temp = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = temp
                }
            }
        }
        return list
    }
}


private class QuickSortStrategy : SortStrategy {
    override fun sort(data: List<Int>): List<Int> {
        if (data.size <= 1) return data
        val pivot = data[data.size / 2]
        val less = data.filter { it < pivot }
        val equal = data.filter { it == pivot }
        val greater = data.filter { it > pivot }
        return sort(less) + equal + sort(greater)
    }
}

private class SortContext(private var strategy: SortStrategy) {
    fun setStrategy(strategy: SortStrategy) {
        this.strategy = strategy
    }

    fun executeSort(data: List<Int>): List<Int> {
        return strategy.sort(data)
    }
}

private fun main() {
    val list = listOf(8,7,5,2,4)
    val context = SortContext(BubbleSortStrategy())
    println(context.executeSort(list))
    context.setStrategy(QuickSortStrategy())
    println(context.executeSort(list))
}

