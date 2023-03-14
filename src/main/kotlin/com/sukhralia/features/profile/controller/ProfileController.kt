package com.sukhralia.features.profile.controller

import com.sukhralia.features.profile.domain.model.CreateUserDTO
import com.sukhralia.features.profile.domain.repository.ProfileRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Routing.profileRoutes() {

    val profileRepository by inject<ProfileRepository>()

    route("/profile") {

        post("/createUser") {

            val createUser = call.receiveNullable<CreateUserDTO>() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val usersDTO = profileRepository.createUser(createUser)
            call.respond(usersDTO)
        }

        get("/getAllUsers") {
            val usersDTO = profileRepository.getAllUsers()
            call.respond(usersDTO)
        }

    }
}