package com.lucassimao.cabojosiasinforma.problem_notifications.data

import com.lucassimao.cabojosiasinforma.problem_notifications.data.source.ProblemNotificationDataSource
import com.lucassimao.cabojosiasinforma.problem_notifications.data.model.ProblemNotificationDataModel
import com.lucassimao.cabojosiasinforma.problem_notifications.domain.repository.ProblemNotificationRepository
import javax.inject.Inject

class ProblemNotificationRepositoryImpl @Inject constructor(
    private val problemNotification: ProblemNotificationDataSource
) : ProblemNotificationRepository {
    override fun sendProblem(problem: ProblemNotificationDataModel): String {
        return problemNotification.sendProblem(problem)
    }
}