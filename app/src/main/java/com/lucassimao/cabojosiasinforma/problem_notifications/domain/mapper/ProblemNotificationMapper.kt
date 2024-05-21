package com.lucassimao.cabojosiasinforma.problem_notifications.domain.mapper

import com.lucassimao.cabojosiasinforma.problem_notifications.data.model.ProblemNotificationDataModel
import com.lucassimao.cabojosiasinforma.problem_notifications.domain.model.ProblemNotificationDomainModel

fun ProblemNotificationDataModel.toDomainModel(): ProblemNotificationDomainModel {
    return ProblemNotificationDomainModel(
        location = location,
        description = description,
        image1 = image1,
        image2 = image2,
        image3 = image3
    )
}

fun ProblemNotificationDomainModel.toDataModel(): ProblemNotificationDataModel {
    return ProblemNotificationDataModel(
        location = location,
        description = description,
        image1 = image1,
        image2 = image2,
        image3 = image3
    )
}