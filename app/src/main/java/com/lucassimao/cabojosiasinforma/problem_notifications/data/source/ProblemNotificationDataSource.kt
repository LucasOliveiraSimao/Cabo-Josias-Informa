package com.lucassimao.cabojosiasinforma.problem_notifications.data.source

import com.lucassimao.cabojosiasinforma.problem_notifications.data.model.ProblemNotificationDataModel

interface ProblemNotificationDataSource {
    fun sendProblem(problem: ProblemNotificationDataModel): String
}