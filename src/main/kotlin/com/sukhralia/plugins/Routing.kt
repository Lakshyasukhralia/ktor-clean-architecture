package com.sukhralia.plugins

import com.sukhralia.features.profile.controller.profileRoutes
import com.sukhralia.util.getTokenConfig
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    val tokenConfig = getTokenConfig(environment)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        profileRoutes(tokenConfig)
    }
}
