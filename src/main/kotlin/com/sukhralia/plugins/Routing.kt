package com.sukhralia.plugins

import com.sukhralia.features.profile.controller.profileRoutes
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        profileRoutes()
    }
}
