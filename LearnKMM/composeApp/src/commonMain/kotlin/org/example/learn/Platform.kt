package org.example.learn

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun httpClient(
    config : HttpClientConfig<*>.() -> Unit = {}
) : HttpClient