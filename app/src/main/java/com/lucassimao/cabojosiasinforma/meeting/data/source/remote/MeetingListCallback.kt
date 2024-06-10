package com.lucassimao.cabojosiasinforma.meeting.data.source.remote

import com.google.firebase.database.DatabaseError
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel

interface MeetingListCallback {
    fun onSuccess(meetingList: List<MeetingDataModel>)
    fun onError(error: DatabaseError)
}