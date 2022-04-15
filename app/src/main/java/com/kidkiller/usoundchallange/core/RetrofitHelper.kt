package com.kidkiller.usoundchallange.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://testing-kit-pro-backend-internal.usound.co/general/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
