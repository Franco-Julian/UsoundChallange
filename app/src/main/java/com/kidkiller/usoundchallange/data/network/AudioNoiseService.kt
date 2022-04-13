package com.kidkiller.usoundchallange.data.network

import com.kidkiller.usoundchallange.core.RetrofitHelper
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val URL = "api/repited-tone/"
private const val API_KEY = "262bce0ecb39887113b5c1638b05ea3b12f23762"

class AudioNoiseService {
    private val retrofit =  RetrofitHelper.getRetrofit()

    suspend fun getAudioNoise(): List<AudioNoiseResponseModel>{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AudioNoiseApiClient::class.java).getNoiseInfo(URL, API_KEY)
            response.body() ?: emptyList()
        }
    }
}