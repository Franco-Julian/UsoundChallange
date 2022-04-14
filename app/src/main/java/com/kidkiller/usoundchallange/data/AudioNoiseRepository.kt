package com.kidkiller.usoundchallange.data

import com.kidkiller.usoundchallange.data.model.AudioNoiseProvider
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.data.network.AudioNoiseService
import javax.inject.Inject

class AudioNoiseRepository @Inject constructor(
    private val api: AudioNoiseService,
    private val audioNoiseProvider: AudioNoiseProvider
) {

    suspend fun getAudioNoise(): List<AudioNoiseResponseModel> {
        val response = api.getAudioNoise()
        audioNoiseProvider.audioNoise = response
        return response
    }
}