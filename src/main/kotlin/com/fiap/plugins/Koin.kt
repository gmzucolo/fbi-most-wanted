package com.fiap.plugins

import com.fiap.di.koinModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(koinModule)
    }
}