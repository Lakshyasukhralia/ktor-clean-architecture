package com.sukhralia.features.profile.domain.repository

import com.sukhralia.features.profile.domain.model.CreateUserDTO
import com.sukhralia.features.profile.domain.model.UserDTO

interface ProfileRepository {
    fun createUser(createUserDTO: CreateUserDTO): UserDTO
    fun getAllUsers(): List<UserDTO>
}