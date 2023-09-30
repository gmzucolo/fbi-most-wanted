package com.fiap

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*

fun HttpClientConfig<CIOEngineConfig>.installJson() {
    install(ContentNegotiation) {
        gson()
    }
}