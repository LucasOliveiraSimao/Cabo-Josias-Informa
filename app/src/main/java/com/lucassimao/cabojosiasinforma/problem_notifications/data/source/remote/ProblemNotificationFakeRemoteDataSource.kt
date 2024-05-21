package com.lucassimao.cabojosiasinforma.problem_notifications.data.source.remote

import com.lucassimao.cabojosiasinforma.problem_notifications.data.model.ProblemNotificationDataModel
import com.lucassimao.cabojosiasinforma.problem_notifications.data.source.ProblemNotificationDataSource
import javax.inject.Inject

class ProblemNotificationFakeRemoteDataSource @Inject constructor() :
    ProblemNotificationDataSource {
    override fun sendProblem(problem: ProblemNotificationDataModel): String {
        return "${problem.location} \n " +
                "${problem.description} \n" +
                "${problem.image1} \n" +
                "${problem.image2} \n" +
                "${problem.image3} \n"
    }
}