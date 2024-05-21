package com.lucassimao.cabojosiasinforma.problem_notifications.di

import com.lucassimao.cabojosiasinforma.problem_notifications.data.ProblemNotificationRepositoryImpl
import com.lucassimao.cabojosiasinforma.problem_notifications.data.source.ProblemNotificationDataSource
import com.lucassimao.cabojosiasinforma.problem_notifications.data.source.remote.ProblemNotificationFakeRemoteDataSource
import com.lucassimao.cabojosiasinforma.problem_notifications.domain.repository.ProblemNotificationRepository
import com.lucassimao.cabojosiasinforma.problem_notifications.domain.use_case.ProblemNotificationUseCase
import com.lucassimao.cabojosiasinforma.problem_notifications.presentation.view_model.ProblemNotificationViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProblemNotification {

    @Provides
    fun provideProblemNotificationDataSource(): ProblemNotificationDataSource =
        ProblemNotificationFakeRemoteDataSource()

    @Provides
    fun provideProblemNotificationRepository(dataSource: ProblemNotificationDataSource): ProblemNotificationRepository =
        ProblemNotificationRepositoryImpl(dataSource)

    @Provides
    fun provideProblemNotificationUseCase(repository: ProblemNotificationRepository): ProblemNotificationUseCase =
        ProblemNotificationUseCase(repository)

    @Provides
    fun provideProblemNotificationViewModel(useCase: ProblemNotificationUseCase): ProblemNotificationViewModel =
        ProblemNotificationViewModel(useCase)


}