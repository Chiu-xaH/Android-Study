package answer.obsever

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 不加锁版本
private fun interface Observer<T> {
    fun onChanged(data : T)
}

private class LiveData<T>  {
    private val observers = mutableSetOf<Observer<T>>()
    private var value : T? = null

    private fun notify(data : T) {
        observers.forEach { observer ->
            observer.onChanged(data)
        }
    }

    fun observe(observer: Observer<T>) {
        observers.add(observer)
        value?.let {
            observer.onChanged(it)
        }
    }

    fun remove(observer: Observer<T>) {
        observers.remove(observer)
    }

    fun setValue(data : T) {
        value = data
        notify(data)
    }
}

private fun test() = runBlocking {
    val liveData = LiveData<String>()

    // 启动协程发送数据
    launch {
        liveData.setValue("第一次更新")
        delay(500)
        liveData.setValue("第二次更新")
    }

    // 启动协程订阅
    launch {
        liveData.observe { data ->
            println("观察者收到: $data")
        }
    }

    delay(1000)
}

fun main() {
    test()
}
