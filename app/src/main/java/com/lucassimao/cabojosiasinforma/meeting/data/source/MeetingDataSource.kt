package com.lucassimao.cabojosiasinforma.meeting.data.source

import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel

interface MeetingDataSource {
    fun fetchMeetings(): List<MeetingDataModel>
}