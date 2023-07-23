package com.spacex.com.di

import com.spacex.com.presentation.details.DetailsViewModel
import com.spacex.com.presentation.missions.MissionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel<MissionsViewModel> {
        MissionsViewModel(
            getLaunchesUseCase = get()
        )
    }

    viewModel<DetailsViewModel> {
        DetailsViewModel(
            getCrewUseCase = get()
        )
    }
}