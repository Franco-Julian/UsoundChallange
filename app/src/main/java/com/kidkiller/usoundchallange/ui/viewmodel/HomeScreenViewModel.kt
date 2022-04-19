package com.kidkiller.usoundchallange.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kidkiller.usoundchallange.domain.GetAudioNoiseUseCase
import com.kidkiller.usoundchallange.domain.model.AudioNoise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAudioNoiseUseCase: GetAudioNoiseUseCase
) : ViewModel() {


    val _audioNoiseList = MutableStateFlow<List<AudioNoise>>(emptyList())
    val audioNoiseList = _audioNoiseList.asStateFlow()

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading = _isLoading

    fun onCreate() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = getAudioNoiseUseCase()

            if (!result.isNullOrEmpty()){
                _audioNoiseList.value = result.sortedWith(compareBy { it.type })
                _isLoading.value = false
            }
        }
    }

}