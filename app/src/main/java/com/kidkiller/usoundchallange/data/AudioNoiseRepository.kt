package com.kidkiller.usoundchallange.data

import com.kidkiller.usoundchallange.data.database.dao.AudioNoiseDao
import com.kidkiller.usoundchallange.data.database.entities.AudioNoiseEntity
import com.kidkiller.usoundchallange.data.model.AudioNoiseProvider
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.data.network.AudioNoiseService
import com.kidkiller.usoundchallange.domain.model.AudioNoise
import com.kidkiller.usoundchallange.domain.model.toDomain
import javax.inject.Inject

class AudioNoiseRepository @Inject constructor(
    private val api: AudioNoiseService,
    private val audioNoiseDao: AudioNoiseDao
) {

    suspend fun getAudioNoiseFromApi(): List<AudioNoise> {
        val response = api.getAudioNoise()
        return response.map { it.toDomain() }
    }

    suspend fun getAudioNoiseFromDatabase(): List<AudioNoise>{
        val response = audioNoiseDao.getAllAudioNoise()
        return response.map { it.toDomain() }
    }

    suspend fun insertAudioNoise(audioNoises: List<AudioNoiseEntity>){
        audioNoiseDao.insertAll(audioNoises)
    }

    suspend fun clearAudioNoise(){
        audioNoiseDao.deleteAllAudioNoise()
    }
}