package com.spacex.com.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spacex.domain.models.crew.CrewModelDomain
import com.spacex.domain.usecase.GetCrewUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(private val getCrewUseCase: GetCrewUseCase) : ViewModel() {
    private var crewLiveData = MutableLiveData<CrewModelDomain?>()
    val _crewLiveData: LiveData<CrewModelDomain?> =
        crewLiveData

    fun getCrew(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = getCrewUseCase.execute(id = id)) {
                is com.spacex.domain.Result.Success -> {
                    crewLiveData.postValue(response.data)
                }
                is com.spacex.domain.Result.Error -> {

                }
                else -> {

                }
            }
        }
    }
}