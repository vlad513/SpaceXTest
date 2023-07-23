package com.spacex.domain.usecase

import com.spacex.domain.Result
import com.spacex.domain.models.crew.CrewModelDomain
import com.spacex.domain.repository.Repository

class GetCrewUseCase(private val repository: Repository) {
    suspend fun execute(id: String): Result<CrewModelDomain?> {
        return repository.getCrew(id = id)
    }
}