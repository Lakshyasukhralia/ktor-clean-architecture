package com.sukhralia.features.profile.controller

import com.sukhralia.features.profile.domain.mapper.toLoginUserResponseDTO
import com.sukhralia.features.profile.domain.mapper.toUserResponseDTO
import com.sukhralia.features.profile.domain.model.CreateUserRequestDTO
import com.sukhralia.features.profile.domain.model.LoginUserRequestDTO
import com.sukhralia.features.profile.domain.repository.ProfileRepository
import com.sukhralia.security.hashing.HashingService
import com.sukhralia.security.hashing.SaltedHash
import com.sukhralia.security.token.TokenClaim
import com.sukhralia.security.token.TokenConfig
import com.sukhralia.security.token.TokenService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Routing.profileRoutes(tokenConfig: TokenConfig) {

    val profileRepository by inject<ProfileRepository>()
    val hashingService by inject<HashingService>()
    val tokenService by inject<TokenService>()

    route("/profile") {

        post("/createUser") {

            val createUserRequestDTO = call.receiveNullable<CreateUserRequestDTO>() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val existingUser = profileRepository.getUserByEmail(createUserRequestDTO.email)
            if (existingUser != null) {
                call.respond(HttpStatusCode.Conflict)
                return@post
            }

            val saltedHash = hashingService.generateSaltedHash(createUserRequestDTO.password)
            createUserRequestDTO.salt = saltedHash.salt
            createUserRequestDTO.hash = saltedHash.hash

            val usersDTO = profileRepository.createUser(createUserRequestDTO)
            call.respond(usersDTO.toUserResponseDTO())
        }

        authenticate {
            get("/getAllUsers") {
                val principal = call.principal<JWTPrincipal>()
                val name = principal?.getClaim("name", String::class)
                println("Get all users requested by $name")

                val usersDTO = profileRepository.getAllUsers()
                call.respond(usersDTO.map { it.toUserResponseDTO() })
            }
        }

        post("/loginUser") {
            val loginUser = call.receiveNullable<LoginUserRequestDTO>() ?: kotlin.run {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val userDTO = profileRepository.getUserByEmail(loginUser.email)
            if (userDTO == null) {
                call.respond(HttpStatusCode.NotFound)
                return@post
            }

            if (userDTO.hash.isNullOrEmpty() || userDTO.salt.isNullOrEmpty()) {
                call.respond(HttpStatusCode.NotAcceptable)
                return@post
            }
            val saltedHash = SaltedHash(
                hash = userDTO.hash!!,
                salt = userDTO.salt!!
            )

            val isValidPassword = hashingService.verify(loginUser.password, saltedHash)
            if (!isValidPassword) {
                call.respond(HttpStatusCode.Conflict, "Incorrect email or password")
                return@post
            }

            val token = tokenService.generate(
                config = tokenConfig,
                TokenClaim(
                    name = "name",
                    value = userDTO.name
                )
            )
            userDTO.token = token

            call.respond(userDTO.toLoginUserResponseDTO())
        }
    }
}