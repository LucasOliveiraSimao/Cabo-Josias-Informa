package com.lucassimao.cabojosiasinforma.problem_notifications.domain.repository

import com.lucassimao.cabojosiasinforma.problem_notifications.data.model.ProblemNotificationDataModel

interface ProblemNotificationRepository {
    fun sendProblem(problem: ProblemNotificationDataModel): String
}