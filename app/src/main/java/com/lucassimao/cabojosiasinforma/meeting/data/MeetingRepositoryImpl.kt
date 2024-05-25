package com.lucassimao.cabojosiasinforma.meeting.data

import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.data.source.MeetingDataSource
import com.lucassimao.cabojosiasinforma.meeting.domain.repository.MeetingRepository
import javax.inject.Inject

class MeetingRepositoryImpl @Inject constructor(
    private val meetingDataSource: MeetingDataSource
) : MeetingRepository {
    override fun fetchMeetings(): List<MeetingDataModel> {
        return meetingDataSource.fetchMeetings()
    }
}