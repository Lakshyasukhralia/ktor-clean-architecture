package com.sukhralia.features.profile.domain.repository

import com.sukhralia.features.profile.data.local.repository.ProfileLocalDataSource
import com.sukhralia.features.profile.domain.mapper.toDTO
import com.sukhralia.features.profile.domain.mapper.toUser
import com.sukhralia.features.profile.domain.model.CreateUserRequestDTO
import com.sukhralia.features.profile.domain.model.UserDTO

class ProfileRepositoryImpl(private val profileLocalDataSource: ProfileLocalDataSource) : ProfileRepository {

    override fun createUser(createUserRequestDTO: CreateUserRequestDTO): UserDTO {
        val user = profileLocalDataSource.createUser(createUserRequestDTO.toUser())
        return user.toDTO()
    }

    override fun getAllUsers(): List<UserDTO> {
        return profileLocalDataSource.getAllUsers().map { it.toDTO() }
    }

    override fun getUserByEmail(email: String): UserDTO? {
        return profileLocalDataSource.getUserByEmail(email)?.toDTO()
    }

}