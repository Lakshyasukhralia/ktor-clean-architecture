package com.sukhralia.di

import com.sukhralia.features.profile.data.local.repository.ProfileLocalDataSource
import com.sukhralia.features.profile.data.local.repository.ProfileLocalDataSourceImpl
import com.sukhralia.features.profile.domain.repository.ProfileRepository
import com.sukhralia.features.profile.domain.repository.ProfileRepositoryImpl
import com.sukhralia.security.hashing.HashingService
import com.sukhralia.security.hashing.SHA256HashingService
import com.sukhralia.security.token.JwtTokenService
import com.sukhralia.security.token.TokenService
import org.koin.dsl.module

val appModule = module {
    single<HashingService> { SHA256HashingService() }
    single<TokenService> { JwtTokenService() }
    single<ProfileLocalDataSource> { ProfileLocalDataSourceImpl() }
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
}