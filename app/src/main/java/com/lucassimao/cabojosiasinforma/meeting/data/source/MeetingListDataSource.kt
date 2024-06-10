package com.lucassimao.cabojosiasinforma.meeting.data.source

import com.lucassimao.cabojosiasinforma.meeting.data.source.remote.MeetingListCallback

interface MeetingListDataSource {
    fun fetchMeetings(callback: MeetingListCallback)
}