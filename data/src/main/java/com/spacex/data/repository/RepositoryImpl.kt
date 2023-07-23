package com.spacex.data.repository


import com.spacex.data.utils.extensions.mapCrew
import com.spacex.data.networking.retrofit.RetrofitCreateRequest
import com.spacex.data.utils.extensions.mapLaunch
import com.spacex.domain.Result
import com.spacex.domain.models.crew.CrewModelDomain
import com.spacex.domain.models.launch.DocksModelDomain
import com.spacex.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val retrofitCreateRequest: RetrofitCreateRequest,
    private val ioDispatcher: CoroutineDispatcher
) : Repository {
    override suspend fun getLaunches(): Result<List<DocksModelDomain>> {
        return withContext(ioDispatcher) {
            try {
                Result.Success(
                    mapLaunch(
                        docs = retrofitCreateRequest.create.getLaunches().body()!!
                    )
                )
            } catch (e: java.lang.Exception) {
                Result.Error(Exception("Error"))
            }
        }


    }

    override suspend fun getCrew(id: String): Result<CrewModelDomain> {
        return withContext(ioDispatcher) {
            try {
                Result.Success(
                    mapCrew(crew = retrofitCreateRequest.create.getCrew(id = id).body()!!)
                )
            } catch (e: java.lang.Exception) {
                Result.Error(Exception("Error"))
            }
        }
    }
}