package com.kidkiller.usoundchallange.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioNoiseProvider @Inject constructor() {
    var audioNoise: List<AudioNoiseResponseModel> = emptyList()
}