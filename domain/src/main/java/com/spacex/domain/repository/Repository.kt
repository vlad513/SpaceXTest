package com.spacex.domain.repository


import com.spacex.domain.models.crew.CrewModelDomain
import com.spacex.domain.models.launch.DocksModelDomain


interface Repository {
    suspend fun getLaunches(): com.spacex.domain.Result<List<DocksModelDomain>>
    suspend fun getCrew(id: String): com.spacex.domain.Result<CrewModelDomain>

}