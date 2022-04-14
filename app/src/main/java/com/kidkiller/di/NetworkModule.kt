package com.kidkiller.di

import com.kidkiller.usoundchallange.data.network.AudioNoiseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://testing-kit-pro-backend-internal.usound.co/general/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAudioNoiseApiClient(retrofit: Retrofit): AudioNoiseApiClient{
        return retrofit.create(AudioNoiseApiClient::class.java)
    }
}