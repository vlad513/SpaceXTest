package com.spacex.com.di

import com.spacex.domain.usecase.GetCrewUseCase
import com.spacex.domain.usecase.GetLaunchesUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<GetLaunchesUseCase> {
        GetLaunchesUseCase(
            repository = get()
        )
    }

    factory<GetCrewUseCase> {
        GetCrewUseCase(
            repository = get()
        )
    }
}