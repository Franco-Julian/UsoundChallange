package com.kidkiller.usoundchallange.domain

import com.kidkiller.usoundchallange.data.AudioNoiseRepository
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import javax.inject.Inject

class GetAudioNoiseUseCase @Inject constructor(private val repository: AudioNoiseRepository) {
    suspend operator fun invoke(): List<AudioNoiseResponseModel> = repository.getAudioNoise()
}