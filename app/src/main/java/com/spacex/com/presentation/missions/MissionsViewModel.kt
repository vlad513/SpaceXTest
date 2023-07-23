package com.spacex.com.presentation.missions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spacex.domain.models.launch.DocksModelDomain
import com.spacex.domain.usecase.GetLaunchesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MissionsViewModel(private val getLaunchesUseCase: GetLaunchesUseCase) : ViewModel() {

    private var missionsLiveData = MutableLiveData<List<DocksModelDomain>?>()
    val _missionsLiveData: LiveData<List<DocksModelDomain>?> =
        missionsLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = getLaunchesUseCase.execute()) {
                is com.spacex.domain.Result.Success -> {
                    missionsLiveData.postValue(response.data)
                }
                is com.spacex.domain.Result.Error -> {

                }
                else -> {

                }
            }

        }
    }

}