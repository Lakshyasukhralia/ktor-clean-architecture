package com.sukhralia.features.profile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequestDTO(
    val name: String,
    val email: String,
    val password: String,
    var salt: String? = null,
    var hash: String? = null
)
