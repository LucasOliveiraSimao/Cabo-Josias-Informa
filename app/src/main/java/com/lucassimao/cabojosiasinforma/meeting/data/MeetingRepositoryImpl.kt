package com.lucassimao.cabojosiasinforma.meeting.data

import com.google.firebase.database.DatabaseError
import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.data.source.MeetingListDataSource
import com.lucassimao.cabojosiasinforma.meeting.data.source.remote.MeetingListCallback
import com.lucassimao.cabojosiasinforma.meeting.domain.repository.MeetingRepository
import javax.inject.Inject

class MeetingRepositoryImpl @Inject constructor(
    private val meetingListDataSource: MeetingListDataSource
) : MeetingRepository {
    override fun fetchMeetings(callback: RepositoryCallback<List<MeetingDataModel>>) {
        return meetingListDataSource.fetchMeetings(object : MeetingListCallback {
            override fun onSuccess(meetingList: List<MeetingDataModel>) {
                callback.onSuccess(meetingList)
            }

            override fun onError(error: DatabaseError) {
                callback.onError(error.toException())
            }
        })
    }
}