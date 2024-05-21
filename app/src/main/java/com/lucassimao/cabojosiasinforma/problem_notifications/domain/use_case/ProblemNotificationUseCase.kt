package com.lucassimao.cabojosiasinforma.problem_notifications.domain.use_case

import com.lucassimao.cabojosiasinforma.problem_notifications.domain.mapper.toDataModel
import com.lucassimao.cabojosiasinforma.problem_notifications.domain.model.ProblemNotificationDomainModel
import com.lucassimao.cabojosiasinforma.problem_notifications.domain.repository.ProblemNotificationRepository
import javax.inject.Inject

class ProblemNotificationUseCase @Inject constructor(
    private val repository: ProblemNotificationRepository
) {
    fun invoke(problem: ProblemNotificationDomainModel): String {
        return repository.sendProblem(problem.toDataModel())
    }
}