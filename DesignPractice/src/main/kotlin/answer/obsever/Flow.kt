package answer.obsever

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private interface IStateHolder<in T> {
    fun emitData(data : T)
    fun emitError(e : Throwable, code : Int?)
    fun clear()
    fun setLoading()
}

private sealed class State<out T> {
    data object Prepare : State<Nothing>()
    data object Loading : State<Nothing>()
    data class Success<T>(val data : T) : State<T>()
    data class Error<T>(val e : Throwable,val code : Int?) : State<T>()
}


private class StateHolder<T> : IStateHolder<T> {
    private val _state = MutableStateFlow<State<T>>(State.Prepare)
    val state : StateFlow<State<T>> = _state

    override fun emitData(data : T) {
        _state.value = State.Success(data)
    }
    override fun emitError(e : Throwable, code : Int?) {
        _state.value = State.Error(e, code)
    }

    override fun clear() {
        _state.value = State.Prepare
    }

    override fun setLoading() {
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