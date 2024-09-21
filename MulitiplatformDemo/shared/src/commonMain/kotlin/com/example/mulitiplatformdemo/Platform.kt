package com.example.mulitiplatformdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform