package com.lucassimao.cabojosiasinforma.meeting.di

import com.google.firebase.database.DatabaseReference
import com.lucassimao.cabojosiasinforma.meeting.data.MeetingRepositoryImpl
import com.lucassimao.cabojosiasinforma.meeting.data.source.MeetingListDataSource
import com.lucassimao.cabojosiasinforma.meeting.data.source.remote.MeetingListListRealtimeDatabase
import com.lucassimao.cabojosiasinforma.meeting.domain.repository.MeetingRepository
import com.lucassimao.cabojosiasinforma.meeting.domain.use_case.MeetingUseCase
import com.lucassimao.cabojosiasinforma.meeting.presentation.view_model.MeetingViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MeetingModules {
    @Provides
    fun provideMeetingDataSource(databaseReference: DatabaseReference): MeetingListDataSource =
        MeetingListListRealtimeDatabase(databaseReference)

    @Provides
    fun provideMeetingRepository(dataSource: MeetingListDataSource): MeetingRepository =
        MeetingRepositoryImpl(dataSource)

    @Provides
    fun provideMeetingUseCase(repository: MeetingRepository): MeetingUseCase =
        MeetingUseCase(repository)

    @Provides
    fun provideMeetingViewModel(useCase: MeetingUseCase): MeetingViewModel =
        MeetingViewModel(useCase)

}