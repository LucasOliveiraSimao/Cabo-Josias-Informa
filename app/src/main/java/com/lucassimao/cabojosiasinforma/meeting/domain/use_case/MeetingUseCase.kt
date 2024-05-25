package com.lucassimao.cabojosiasinforma.meeting.domain.use_case

import com.lucassimao.cabojosiasinforma.home.domain.repository.HomeRepository
import com.lucassimao.cabojosiasinforma.meeting.domain.repository.MeetingRepository
import javax.inject.Inject

class MeetingUseCase @Inject constructor(
    private val meetingRepository: MeetingRepository
) {
    fun fetchMeetings() = meetingRepository.fetchMeetings()
}