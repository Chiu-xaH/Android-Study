package answer.obsever

import kotlinx.coroutines.*

private fun interface LiveObserver<T> {
    fun onChanged(value: T)
}

private class MyLiveData<T> {
    private val observers = mutableSetOf<LiveObserver<T>>()
    private var data: T? = null
    private val lock = Any() // 锁

    // 添加观察者
    fun observe(observer: LiveObserver<T>) {
        val currentData: T?
        synchronized(lock) {
            observers.add(observer)
            currentData = data
        }
        // 如果已有值，立即通知一次（锁外调用，避免死锁）
        currentData?.let { observer.onChanged(it) }
    }

    // 移除观察者
    fun removeObserver(observer: LiveObserver<T>) = synchronized(lock) {
        observers.remove(observer)
    }

    // 设置值并通知观察者
    fun setValue(value: T) {
        val snapshot: List<LiveObserver<T>>
        synchronized(lock) {
            data = value
            snapshot = observers.toList() // 拷贝快照，锁外通知
        }
        notifyObservers(snapshot, value)
    }

    private fun notifyObservers(observersSnapshot: List<LiveObserver<T>>, value: T) {
        observersSnapshot.forEach {
            it.onChanged(value)
        }
    }
}

private fun test() = runBlocking {
    val liveData = MyLiveData<String>()

    // 启动协程发送数据
    launch {
        liveData.setValue("第一次更新")
        delay(500)
        liveData.setValue("第二次更新")
    }

    // 启动协程订阅
    launch {
        liveData.observe { value ->
            println("观察者收到: $value")
        }
    }

    delay(1000)
}

fun main() {
    test()
}
