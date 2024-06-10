package com.lucassimao.cabojosiasinforma.biography.di

import com.google.firebase.database.DatabaseReference
import com.lucassimao.cabojosiasinforma.biography.data.BiographyRepositoryImpl
import com.lucassimao.cabojosiasinforma.biography.data.source.BiographyDataSource
import com.lucassimao.cabojosiasinforma.biography.data.source.remote.BiographyRealtimeDatabase
import com.lucassimao.cabojosiasinforma.biography.domain.repository.BiographyRepository
import com.lucassimao.cabojosiasinforma.biography.domain.use_case.BiographyUseCase
import com.lucassimao.cabojosiasinforma.biography.presentation.view_model.BiographyViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BiographyModules {
    @Provides
    fun provideBiographyDataSource(databaseReference: DatabaseReference): BiographyDataSource =
        BiographyRealtimeDatabase(databaseReference)

    @Provides
    fun provideBiographyRepository(dataSource: BiographyDataSource): BiographyRepository =
        BiographyRepositoryImpl(dataSource)

    @Provides
    fun provideBiographyUseCase(repository: BiographyRepository): BiographyUseCase =
        BiographyUseCase(repository)

    @Provides
    fun provideBiographyViewModel(useCase: BiographyUseCase): BiographyViewModel =
        BiographyViewModel(useCase)
}