package com.sukhralia.features.profile.data.local.repository

import com.sukhralia.features.profile.data.local.dao.User

class ProfileLocalDataSourceImpl : ProfileLocalDataSource {

    private val users = mutableListOf<User>()

    override fun createUser(user: User): User {
        users.add(user)
        return user
    }

    override fun getAllUsers(): List<User> {
        return users
    }
}