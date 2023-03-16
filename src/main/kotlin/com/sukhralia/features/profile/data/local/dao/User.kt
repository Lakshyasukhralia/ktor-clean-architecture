package com.sukhralia.features.profile.data.local.dao

data class User(
    val name: String,
    val email: String,
    val salt: String? = null,
    val hash: String? = null
)
