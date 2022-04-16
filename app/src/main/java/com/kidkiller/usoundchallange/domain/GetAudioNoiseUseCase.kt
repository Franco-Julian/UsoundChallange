package com.kidkiller.usoundchallange.domain

import com.kidkiller.usoundchallange.data.AudioNoiseRepository
import com.kidkiller.usoundchallange.data.database.entities.toDatabase
import com.kidkiller.usoundchallange.domain.model.AudioNoise
import javax.inject.Inject

class GetAudioNoiseUseCase @Inject constructor(private val repository: AudioNoiseRepository) {

    suspend operator fun invoke(): List<AudioNoise> {
        val audioNoise = repository.getAudioNoiseFromApi()

         if (audioNoise.isNotEmpty()){
            repository.clearAudioNoise()
            repository.insertAudioNoise(audioNoise.map { it.toDatabase() }.sortedWith(compareBy { it.type }))
            return audioNoise
        }else{
            return repository.getAudioNoiseFromDatabase()
        }
    }
}