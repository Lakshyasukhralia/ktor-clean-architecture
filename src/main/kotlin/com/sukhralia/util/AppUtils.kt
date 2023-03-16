package com.sukhralia.util

import com.sukhralia.security.token.TokenConfig
import io.ktor.server.application.*

fun getTokenConfig(environment: ApplicationEnvironment) = TokenConfig(
    issuer = environment.config.property("jwt.issuer").getString(),
    audience = environment.config.property("jwt.audience").getString(),
    expiresIn = 365L * 1000L * 60L * 60L * 24L,
    secret = "my_secret"
)
