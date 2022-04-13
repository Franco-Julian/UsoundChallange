package com.kidkiller.usoundchallange.data

import com.kidkiller.usoundchallange.data.model.AudioNoiseProvider
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.data.network.AudioNoiseService

class AudioNoiseRepository {

    private val api = AudioNoiseService()

    suspend fun getAudioNoise(): List<AudioNoiseResponseModel>{
        val response = api.getAudioNoise()
        AudioNoiseProvider.audioNoise = response
        return response
    }
}