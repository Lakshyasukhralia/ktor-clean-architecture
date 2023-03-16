package com.sukhralia.features.profile.data.local.repository

import com.sukhralia.features.profile.data.local.dao.User

interface ProfileLocalDataSource {
    fun createUser(user: User): User
    fun getAllUsers(): List<User>
    fun getUserByEmail(email: String): User?
}