package com.sukhralia.plugins

import com.sukhralia.di.appModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDependency() {
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
}

