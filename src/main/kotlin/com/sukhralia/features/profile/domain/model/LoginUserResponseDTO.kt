package com.sukhralia.features.profile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginUserResponseDTO(
    val name: String,
    val email: String,
    val token: String,
)