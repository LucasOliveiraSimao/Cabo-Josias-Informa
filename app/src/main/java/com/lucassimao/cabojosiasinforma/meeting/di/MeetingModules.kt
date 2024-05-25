package com.lucassimao.cabojosiasinforma.meeting.di

import com.lucassimao.cabojosiasinforma.meeting.data.MeetingRepositoryImpl
import com.lucassimao.cabojosiasinforma.meeting.data.source.MeetingDataSource
import com.lucassimao.cabojosiasinforma.meeting.data.source.remote.MeetingFakeRemoteDataSource
import com.lucassimao.cabojosiasinforma.meeting.domain.repository.MeetingRepository
import com.lucassimao.cabojosiasinforma.meeting.domain.use_case.MeetingUseCase
import com.lucassimao.cabojosiasinforma.meeting.presentation.ui.MeetingAdapter
import com.lucassimao.cabojosiasinforma.meeting.presentation.view_model.MeetingViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MeetingModules {
    @Provides
    fun provideMeetingDataSource(): MeetingDataSource = MeetingFakeRemoteDataSource()

    @Provides
    fun provideMeetingRepository(dataSource: MeetingDataSource): MeetingRepository =
        MeetingRepositoryImpl(dataSource)

    @Provides
    fun provideMeetingUseCase(repository: MeetingRepository): MeetingUseCase = MeetingUseCase(repository)

    @Provides
    fun provideMeetingViewModel(useCase: MeetingUseCase): MeetingViewModel = MeetingViewModel(useCase)

    @Provides
    fun provideMeetingAdapter(): MeetingAdapter = MeetingAdapter()
}