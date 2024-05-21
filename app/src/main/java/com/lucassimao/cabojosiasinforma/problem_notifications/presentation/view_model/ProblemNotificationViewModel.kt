package com.lucassimao.cabojosiasinforma.problem_notifications.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.problem_notifications.domain.use_case.ProblemNotificationUseCase
import com.lucassimao.cabojosiasinforma.problem_notifications.presentation.mapper.toDomainModel
import com.lucassimao.cabojosiasinforma.problem_notifications.presentation.model.ProblemNotificationUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProblemNotificationViewModel @Inject constructor(
    private val useCase: ProblemNotificationUseCase
) : ViewModel() {
    fun sendProblemNotifications(problem: ProblemNotificationUiModel) = useCase.invoke(problem.toDomainModel())
}