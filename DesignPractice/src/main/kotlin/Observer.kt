import kotlinx.coroutines.*

private fun interface Observer<T> {
    fun onChanged(value: T)
}

private class MyLiveData<T> {
    private val observers = mutableListOf<Observer<T>>()
    private var data: T? = null

    // 添加观察者
    fun observe(observer: Observer<T>) {
        observers.add(observer)
        data?.let {
            observer.onChanged(it)
        }
    }

    // 设置值并通知观察者
    fun setValue(value: T) {
        data = value
        notifyObservers(value)
    }

    private fun notifyObservers(value: T) {
        observers.forEach {
            it.onChanged(value)
        }
    }
}

private fun test() = runBlocking {
    val liveData = MyLiveData<String>()
    launch {
        // 发送
        liveData.setValue("第一次更新")
        delay(1000L)
        liveData.setValue("第二次更新")
    }
    launch {
        // 订阅
        liveData.observe { value ->
            println("观察者收到: $value")
        }
    }
}

private fun main() {
    test()
}