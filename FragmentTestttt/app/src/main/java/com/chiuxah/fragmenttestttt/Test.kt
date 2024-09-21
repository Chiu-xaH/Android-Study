import kotlin.reflect.KProperty

class Later<T>(val block : () -> T) {
    var v : Any? = null
    operator fun getValue(any : Any?, prop :KProperty<*> ) : T {
        if (v == block)   v = block()
        return v as T
        block by lazy {  }
    }

}

fun <T> later(block: () -> T) = Later(block)