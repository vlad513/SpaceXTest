package com.spacex.domain.repository


import com.spacex.domain.Result
import com.spacex.domain.models.crew.CrewModelDomain
import com.spacex.domain.models.launch.DocksModelDomain


interface Repository {
    suspend fun getLaunches(): Result<List<DocksModelDomain>?>
    suspend fun getCrew(id: String): Result<CrewModelDomain?>

}