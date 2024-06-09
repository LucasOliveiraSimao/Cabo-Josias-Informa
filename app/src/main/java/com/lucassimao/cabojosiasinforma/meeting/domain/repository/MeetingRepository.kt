package com.lucassimao.cabojosiasinforma.meeting.domain.repository

import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel

interface MeetingRepository {
    fun fetchMeetings(callback: RepositoryCallback<List<MeetingDataModel>>)
}