package com.spacex.domain.usecase

import com.spacex.domain.models.crew.CrewModelDomain
import com.spacex.domain.repository.Repository

class GetCrewUseCase(private val repository: Repository) {
    suspend fun execute(id: String): com.spacex.domain.Result<CrewModelDomain> {
        return repository.getCrew(id = id)
    }
}