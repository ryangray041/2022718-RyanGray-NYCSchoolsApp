package com.example.nycschoolsv2.di

import com.example.nycschoolsv2.network.SchoolsRepository
import com.example.nycschoolsv2.network.SchoolsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesRepository(
        schoolsRepositoryImpl: SchoolsRepositoryImpl
    ): SchoolsRepository

}