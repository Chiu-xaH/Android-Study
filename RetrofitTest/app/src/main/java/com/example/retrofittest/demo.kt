import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
   runBlocking {
       val start = System.currentTimeMillis()
       val r = async {
          // delay(1000)
           5 + 5 }.await()
       println(r)
       val end = System.currentTimeMillis()
       println("${end - start} ms")
   }
}