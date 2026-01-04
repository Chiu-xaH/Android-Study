class LruCache<K,V>(private val capacity: Int) {
    private class Node<K,V>(
        var key : K?,
        var value : V?,
    ) {
        var before : Node<K,V>? = null
        var after : Node<K,V>? = null
    }

    private val hashMap = mutableMapOf<K,Node<K,V>>()
    private val head : Node<K,V> = Node(null,null)
    private val tail : Node<K,V> = Node(null,null)

    init {
        head.after = tail
        tail.before = head
    }

    private fun Node<K,V>.moveNode() {
        // 连接
        this.before?.after = this.after
        this.after?.before = this.before
        // 断开
        this.before = null
        this.after = null
    }

    private fun Node<K,V>.addToHead() {
        val headNext = head.after

        head.after = this
        headNext?.before = this
        this.after = headNext
        this.before = head
    }

    fun get(key : K) : V? {
        return if(!hashMap.containsKey(key)) {
            // 返回空
            null
        } else {
            // 取出并移动到头部
            val node = hashMap[key]!!
            node.moveNode()
            node.addToHead()
            node.value
        }
    }

    private fun isFull() = hashMap.size >= capacity

    fun put(key : K,value : V) {
        if(!hashMap.containsKey(key)) {
            // 检查是否满
            if(isFull()) {
                // 逐出最久
                val node = tail.before
                node?.let {
                    it.moveNode()
                    // 释放
                    hashMap.remove(it.key)
                }
            }
            // 插入结点到队头和哈希表
            val node = Node(key,value)
            node.addToHead()
            hashMap[key] = node
        } else {
            // 已有
            // 更新值
            val node = hashMap[key]!!
            node.value = value
            // 移动到头部
            node.moveNode()
            // 插头
            node.addToHead()
        }
    }
}

fun main() {
    val cache = LruCache<Int, String>(3)

    // 插入三个元素
    cache.put(1, "A")
    cache.put(2, "B")
    cache.put(3, "C")

    println(cache.get(1)) // 输出: A
    println(cache.get(2)) // 输出: B

    // 插入新元素，容量满，应该淘汰最久未使用的3
    cache.put(4, "D")

    println(cache.get(3)) // 输出: null，因为被淘汰了
    println(cache.get(4)) // 输出: D
    println(cache.get(1)) // 输出: A

    // 更新已有元素
    cache.put(2, "B_updated")
    println(cache.get(2)) // 输出: B_updated

    // 再插入新元素，淘汰最久未使用的4
    cache.put(5, "E")
    println(cache.get(4)) // 输出: null
    println(cache.get(5)) // 输出: E
    println(cache.get(2)) // 输出: B_updated
}
