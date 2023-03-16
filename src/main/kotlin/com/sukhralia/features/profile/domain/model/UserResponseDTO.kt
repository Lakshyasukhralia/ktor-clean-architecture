package com.sukhralia.features.profile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDTO(
    val name: String,
    val email: String,
)
