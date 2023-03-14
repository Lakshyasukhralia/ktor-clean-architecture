package com.sukhralia.features.profile.domain.mapper

import com.sukhralia.features.profile.data.local.dao.User
import com.sukhralia.features.profile.domain.model.CreateUserDTO
import com.sukhralia.features.profile.domain.model.UserDTO

fun User.toDTO() = UserDTO(name, email)

fun CreateUserDTO.toUser() = User(name, email)