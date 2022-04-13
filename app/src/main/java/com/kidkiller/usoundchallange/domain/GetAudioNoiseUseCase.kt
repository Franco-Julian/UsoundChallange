package com.kidkiller.usoundchallange.domain

import com.kidkiller.usoundchallange.data.AudioNoiseRepository
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel

class GetAudioNoiseUseCase {
    private val repository = AudioNoiseRepository()

    suspend operator fun invoke(): List<AudioNoiseResponseModel>? = repository.getAudioNoise()
}