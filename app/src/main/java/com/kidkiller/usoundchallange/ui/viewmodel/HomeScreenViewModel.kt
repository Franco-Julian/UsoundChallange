package com.kidkiller.usoundchallange.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.domain.GetAudioNoiseUseCase
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    val audioNoiseList = MutableLiveData<List<AudioNoiseResponseModel>>(emptyList())
    val isLoading = MutableLiveData<Boolean>()

    var getAudioNoiseUseCase = GetAudioNoiseUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAudioNoiseUseCase()

            if (!result.isNullOrEmpty()){
                audioNoiseList.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

}