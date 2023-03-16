package com.sukhralia.features.profile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginUserRequestDTO(
    val email: String,
    val password: String
)