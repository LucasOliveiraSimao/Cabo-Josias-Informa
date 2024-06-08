package com.lucassimao.cabojosiasinforma.project_list.di

import com.google.firebase.database.DatabaseReference
import com.lucassimao.cabojosiasinforma.project_list.data.ProjectListRepositoryImpl
import com.lucassimao.cabojosiasinforma.project_list.data.source.ProjectListDataSource
import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.ProjectListRealtimeDatabase
import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import com.lucassimao.cabojosiasinforma.project_list.domain.use_case.ProjectListUseCase
import com.lucassimao.cabojosiasinforma.project_list.presentation.view_model.ProjectListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProjectListModules {
    @Provides
    fun provideProjectDataSource(databaseReference: DatabaseReference): ProjectListDataSource =
        ProjectListRealtimeDatabase(databaseReference)

    @Provides
    fun provideProjectRepository(dataSource: ProjectListDataSource): ProjectListRepository =
        ProjectListRepositoryImpl(dataSource)

    @Provides
    fun provideProjectUseCase(repository: ProjectListRepository): ProjectListUseCase =
        ProjectListUseCase(repository)

    @Provides
    fun provideProjectViewModel(useCase: ProjectListUseCase): ProjectListViewModel =
        ProjectListViewModel(useCase)
}