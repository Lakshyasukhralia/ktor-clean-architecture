package com.sukhralia

import com.sukhralia.plugins.*
import io.ktor.server.application.*
import io.ktor.server.netty.*


fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureDependency()
    configureSerialization()
    configureMonitoring()
    configureSecurity()
    configureRouting()
}
