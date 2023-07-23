package com.spacex.com.di

import com.spacex.data.networking.retrofit.RetrofitBuilder
import com.spacex.data.networking.retrofit.RetrofitCreateRequest
import com.spacex.data.repository.RepositoryImpl
import com.spacex.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.coroutineContext


val dataModule = module {
    single<Repository> {
        RepositoryImpl(retrofitCreateRequest = get(),
        ioDispatcher = Dispatchers.IO)
    }
    single<RetrofitBuilder> {
        RetrofitBuilder()
    }
    single<RetrofitCreateRequest> {
        RetrofitCreateRequest(retrofitBuilder = get())
    }
}