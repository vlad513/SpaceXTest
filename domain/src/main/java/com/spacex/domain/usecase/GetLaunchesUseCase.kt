package com.spacex.domain.usecase

import com.spacex.domain.models.launch.DocksModelDomain
import com.spacex.domain.repository.Repository

class GetLaunchesUseCase(private val repository: Repository) {
    suspend fun execute(): com.spacex.domain.Result<List<DocksModelDomain>> {
        return repository.getLaunches()
    }
}