package com.kidkiller.usoundchallange.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel

class HomeScreenViewModel: ViewModel() {

    val _audioNoiseModel = MutableLiveData<AudioNoiseResponseModel>()
}