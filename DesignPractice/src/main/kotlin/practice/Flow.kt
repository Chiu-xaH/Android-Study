package practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private sealed class State<out T> {
    data object Prepare : State<Nothing>()
    data object Loading : State<Nothing>()
    data class Success<T>(val data : T) : State<T>()
    data class Error<T>(val code : Int?,val exception : Exception) : State<T>()
}

private class StateHolder<T> {
    private val _state = MutableStateFlow<State<T>>(State.Prepare)
    val state : StateFlow<State<T>> = _state
    // 成功得到数据
    fun emitData(data : T) {
        _state.value = State.Success(data)
    }
    // 抛出错误
    fun emitError(code : Int?,exception : Exception) {
        _state.value = State.Error(code,exception)
    }
    // 复原
    fun clear() {
        _state.value = State.Prepare
    }
    // 开始加载
    fun setLoading() {
        _state.value = State.Loading
    }
}


private class MyViewModel() {
    val state = StateHolder<String>()

    suspend fun fetchData() = withContext(Dispatchers.IO) {
        state.setLoading()
        delay(1000L)
        state.emitData("200")
    }
}

private fun test(viewModel : MyViewModel) = runBlocking {
    viewModel.fetchData()
    val result = viewModel.state.state.first()
    println(result)
}

private fun main() {
    val viewModel = MyViewModel()
    test(viewModel)
}