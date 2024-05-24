package com.lucassimao.cabojosiasinforma.project_list.di

import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import com.lucassimao.cabojosiasinforma.project_list.domain.use_case.ProjectListUseCase
import com.lucassimao.cabojosiasinforma.project_list.presentation.ui.project_list.ProjectListAdapter
import com.lucassimao.cabojosiasinforma.project.presentation.view_model.ProjectListViewModel
import com.lucassimao.cabojosiasinforma.project_list.data.ProjectListRepositoryImpl
import com.lucassimao.cabojosiasinforma.project_list.data.source.ProjectListDataSource
import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.ProjectListFakeRemoteListDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProjectListModules {
    @Provides
    fun provideProjectDataSource(): ProjectListDataSource = ProjectListFakeRemoteListDataSource()

    @Provides
    fun provideProjectRepository(dataSource: ProjectListDataSource): ProjectListRepository =
        ProjectListRepositoryImpl(dataSource)

    @Provides
    fun provideProjectUseCase(repository: ProjectListRepository): ProjectListUseCase =
        ProjectListUseCase(repository)

    @Provides
    fun provideProjectViewModel(useCase: ProjectListUseCase): ProjectListViewModel =
        ProjectListViewModel(useCase)

    @Provides
    fun provideProjectListAdapter(): ProjectListAdapter = ProjectListAdapter()
}