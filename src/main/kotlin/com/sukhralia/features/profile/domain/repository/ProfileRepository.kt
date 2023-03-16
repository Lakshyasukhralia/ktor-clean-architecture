package com.sukhralia.features.profile.domain.repository

import com.sukhralia.features.profile.domain.model.CreateUserRequestDTO
import com.sukhralia.features.profile.domain.model.UserDTO

interface ProfileRepository {
    fun createUser(createUserRequestDTO: CreateUserRequestDTO): UserDTO
    fun getAllUsers(): List<UserDTO>
    fun getUserByEmail(email: String): UserDTO?
}