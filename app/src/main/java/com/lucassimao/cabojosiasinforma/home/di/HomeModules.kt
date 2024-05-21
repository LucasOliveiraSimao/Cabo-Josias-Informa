package com.lucassimao.cabojosiasinforma.home.di

import com.lucassimao.cabojosiasinforma.home.data.HomeRepositoryImpl
import com.lucassimao.cabojosiasinforma.home.data.source.HomeDataSource
import com.lucassimao.cabojosiasinforma.home.data.source.remote.HomeFakeRemoteDataSource
import com.lucassimao.cabojosiasinforma.home.domain.repository.HomeRepository
import com.lucassimao.cabojosiasinforma.home.domain.use_case.HomeUseCase
import com.lucassimao.cabojosiasinforma.home.presentation.ui.HomeAdapter
import com.lucassimao.cabojosiasinforma.home.presentation.view_model.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeModules {
    @Provides
    fun provideHomeDataSource(): HomeDataSource = HomeFakeRemoteDataSource()

    @Provides
    fun provideHomeRepository(dataSource: HomeDataSource): HomeRepository =
        HomeRepositoryImpl(dataSource)

    @Provides
    fun provideHomeUseCase(repository: HomeRepository): HomeUseCase = HomeUseCase(repository)

    @Provides
    fun provideHomeViewModel(useCase: HomeUseCase): HomeViewModel = HomeViewModel(useCase)

    @Provides
    fun provideHomeAdapter(): HomeAdapter = HomeAdapter()
}