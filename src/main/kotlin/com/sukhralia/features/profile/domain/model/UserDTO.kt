package com.sukhralia.features.profile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val name: String,
    val email: String,

    var salt: String? = null,
    var hash: String? = null,
    var token: String? = null
)

