package com.lucassimao.cabojosiasinforma.meeting.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.domain.use_case.MeetingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MeetingViewModel @Inject constructor(
    private val meetingUseCase: MeetingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<MeetingDataModel>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<MeetingDataModel>>> get() = _uiState
    fun fetchMeetings() {
        _uiState.value = UiState.Loading
        meetingUseCase.fetchMeetings(object : UseCaseCallback<List<MeetingDataModel>> {
            override fun onSuccess(data: List<MeetingDataModel>) {
                _uiState.value = UiState.Success(data)
            }

            override fun onError(error: Throwable) {
                _uiState.value = UiState.Error(error)
            }
        })
    }
}