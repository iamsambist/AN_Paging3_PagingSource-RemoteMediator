package com.sunaa.paginationstimulation.di

import com.sunaa.paginationstimulation.remote.FakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun provideFakeRepository(): FakeRepository {
        return FakeRepository()
    }
}