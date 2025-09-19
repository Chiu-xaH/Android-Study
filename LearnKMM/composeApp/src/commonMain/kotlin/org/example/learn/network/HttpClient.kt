package org.example.learn.network

val httpClient = httpClient {
    install(DefaultRequest) {
        url {
            protocol = URLProtocol.HTTP  // HTTP协议
            host = "192.168.31.229"      // 本地IP
            port = 8088                  // 本地端口
        }
    }
    install(Logging) {
        level = LogLevel.ALL
    }
    install(HttpCookies) {
        storage = AcceptAllCookiesStorage()
    }
    install(ContentNegotiation) {
        json()
    }
}

