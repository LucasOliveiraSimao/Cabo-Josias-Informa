package com.lucassimao.cabojosiasinforma.meeting.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.home.domain.use_case.HomeUseCase
import com.lucassimao.cabojosiasinforma.meeting.domain.use_case.MeetingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MeetingViewModel @Inject constructor(
    private val meetingUseCase: MeetingUseCase
) : ViewModel() {
    fun fetchMeetings() = meetingUseCase.fetchMeetings()
}