package com.kidkiller.usoundchallange.data.network

import com.kidkiller.usoundchallange.model.AudioNoiseResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface AudioNoiseApiClient {
    @Headers( "Content-Type: application/json; charset=utf-8")
    @GET("{url}")
    fun getNoiseInfo(
        @Path("url") url: String,
        @Header("Authorization") token: String
    ): Response<List<AudioNoiseResponseModel>>
}