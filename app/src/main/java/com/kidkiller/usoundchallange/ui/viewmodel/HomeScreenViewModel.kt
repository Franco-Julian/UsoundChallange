package com.kidkiller.usoundchallange.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.domain.GetAudioNoiseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAudioNoiseUseCase: GetAudioNoiseUseCase
) : ViewModel() {

    val audioNoiseList = MutableLiveData<List<AudioNoiseResponseModel>>(emptyList())
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAudioNoiseUseCase()

            if (!result.isNullOrEmpty()){
                audioNoiseList.postValue(result.sortedWith(compareBy { it.type }))
                isLoading.postValue(false)
            }
        }
    }

}