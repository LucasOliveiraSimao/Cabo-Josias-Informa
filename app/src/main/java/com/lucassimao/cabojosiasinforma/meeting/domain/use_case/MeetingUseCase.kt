package com.lucassimao.cabojosiasinforma.meeting.domain.use_case

import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.domain.repository.MeetingRepository
import javax.inject.Inject

class MeetingUseCase @Inject constructor(
    private val meetingRepository: MeetingRepository
) {
    fun fetchMeetings(callback: UseCaseCallback<List<MeetingDataModel>>) {
        meetingRepository.fetchMeetings(object : RepositoryCallback<List<MeetingDataModel>> {
            override fun onSuccess(data: List<MeetingDataModel>) {
                callback.onSuccess(data)
            }

            override fun onError(error: Throwable) {
                callback.onError(error)
            }
        })
    }
}