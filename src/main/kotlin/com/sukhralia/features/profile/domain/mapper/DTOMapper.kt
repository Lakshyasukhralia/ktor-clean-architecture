package com.sukhralia.features.profile.domain.mapper

import com.sukhralia.features.profile.data.local.dao.User
import com.sukhralia.features.profile.domain.model.*

fun User.toDTO() = UserDTO(name, email, salt, hash)

fun CreateUserRequestDTO.toUser() = User(name, email, salt, hash)

fun UserDTO.toLoginUserResponseDTO() = LoginUserResponseDTO(name, email, token!!)

fun UserDTO.toUserResponseDTO() = UserResponseDTO(name, email)