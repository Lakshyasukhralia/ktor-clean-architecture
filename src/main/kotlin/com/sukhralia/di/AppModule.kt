package com.sukhralia.di

import com.sukhralia.features.profile.data.local.repository.ProfileLocalDataSource
import com.sukhralia.features.profile.data.local.repository.ProfileLocalDataSourceImpl
import com.sukhralia.features.profile.domain.repository.ProfileRepository
import com.sukhralia.features.profile.domain.repository.ProfileRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single<ProfileLocalDataSource> { ProfileLocalDataSourceImpl() }
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
}