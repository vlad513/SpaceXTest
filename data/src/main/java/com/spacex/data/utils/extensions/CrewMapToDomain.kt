package com.spacex.data.utils.extensions

import com.spacex.data.networking.models.crew.CrewModelData
import com.spacex.domain.models.crew.CrewModelDomain
import com.spacex.domain.repository.Repository

fun Repository.mapCrew(crew: CrewModelData): CrewModelDomain {
    return CrewModelDomain(
        name = crew.name,
        agency = crew.agency,
        image = crew.image,
        wikipedia = crew.wikipedia,
        launches = crew.launches,
        status = crew.status,
        id = crew.id
    )}