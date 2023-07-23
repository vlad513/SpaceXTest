package com.spacex.data.networking.remote

import com.spacex.data.networking.models.crew.CrewModelData
import com.spacex.data.networking.models.launches.DocksModelData

import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("launches")
    suspend fun getLaunches(
    ): Response<List<DocksModelData>>

    @GET("crew/{id}")
    suspend fun getCrew(
        @Path("id") id:String
    ): Response<CrewModelData>
}