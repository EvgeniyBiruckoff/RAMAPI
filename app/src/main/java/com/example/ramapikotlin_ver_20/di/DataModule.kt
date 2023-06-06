package com.example.ramapikotlin_ver_20.di

import com.example.ramapikotlin_ver_20.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(): Repository {
    return com.example.ramapikotlin_ver_20.respository.Repository()
    }
}