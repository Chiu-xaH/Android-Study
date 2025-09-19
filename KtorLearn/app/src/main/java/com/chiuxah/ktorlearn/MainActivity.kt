package com.chiuxah.ktorlearn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.chiuxah.ktorlearn.ui.theme.KtorLearnTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ParametersBuilder
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtorLearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UI()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UI() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Ktor学习") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding->
        MainUI(innerPadding)
    }
}

@Composable
fun MainUI(innerPadding: PaddingValues) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            coroutineScope.launch {
                val result = MyAPISource.instance.getAPI()
                result.onSuccess { response ->
                    println("Response: $response")
                    Toast.makeText(context, "成功获取数据：${response}", Toast.LENGTH_SHORT).show()
                }.onFailure { error ->
                    println("Error: ${error.localizedMessage}")
                    Toast.makeText(context, "获取数据失败：${error.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            }
        }) {
            Text(text = "测试打印")
        }
    }
}

val httpClient = HttpClient(Android) {
    defaultRequest {
        url {
            protocol = URLProtocol.HTTP
            host = "8.154.28.108"
        }
    }
    install(ContentNegotiation) {
        json()
    }
}

interface MyAPISource {
    suspend fun getAPI(): Result<String>

    companion object {
        val instance = MyAPISourceImpl(httpClient)
    }
}

class MyAPISourceImpl(
    private val client: HttpClient
) : MyAPISource {
    override suspend fun getAPI(): Result<String> = runCatching {
        val response: HttpResponse = client.get("getSongmid?songid=123")
        val responseBody : String = response.body()
        println("Response: $responseBody")
        responseBody
    }
}
