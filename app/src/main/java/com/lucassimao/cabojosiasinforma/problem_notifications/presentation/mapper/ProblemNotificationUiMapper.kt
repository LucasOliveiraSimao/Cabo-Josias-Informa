package com.lucassimao.cabojosiasinforma.problem_notifications.presentation.mapper

import com.lucassimao.cabojosiasinforma.problem_notifications.domain.model.ProblemNotificationDomainModel
import com.lucassimao.cabojosiasinforma.problem_notifications.presentation.model.ProblemNotificationUiModel

fun ProblemNotificationDomainModel.toUiModel(): ProblemNotificationUiModel {
    return ProblemNotificationUiModel(
        location = location,
        description = description,
        image1 = image1,
        image2 = image2,
        image3 = image3
    )
}

fun ProblemNotificationUiModel.toDomainModel(): ProblemNotificationDomainModel {
    return ProblemNotificationDomainModel(
        location = location,
        description = description,
        image1 = image1,
        image2 = image2,
        image3 = image3
    )
}