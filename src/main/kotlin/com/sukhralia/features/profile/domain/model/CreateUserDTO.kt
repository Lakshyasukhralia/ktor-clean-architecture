package com.sukhralia.features.profile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserDTO(
    val name: String,
    val email: String
)
