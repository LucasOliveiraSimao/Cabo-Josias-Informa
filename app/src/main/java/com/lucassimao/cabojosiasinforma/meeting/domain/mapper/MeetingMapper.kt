package com.lucassimao.cabojosiasinforma.meeting.domain.mapper

import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.domain.model.MeetingDomainModel
import com.lucassimao.cabojosiasinforma.meeting.presentation.model.MeetingUiModel

fun MeetingDataModel.toDomainModel(): MeetingDomainModel {
    return MeetingDomainModel(
        title = title,
        date = date,
        location = location,
        objective = objective,
        participants = participants
    )
}

fun MeetingDomainModel.toUiModel(): MeetingUiModel {
    return MeetingUiModel(
        title = title,
        date = date,
        location = location,
        objective = objective,
        participants = participants
    )
}