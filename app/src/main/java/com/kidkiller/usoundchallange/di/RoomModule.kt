package com.kidkiller.usoundchallange.di

import android.content.Context
import androidx.room.Room
import com.kidkiller.usoundchallange.data.database.AudioNoiseDatabase
import com.kidkiller.usoundchallange.data.database.dao.AudioNoiseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val AUDIONOISE_DATABASE_NAME = "audioNoise_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): AudioNoiseDatabase =
        Room.databaseBuilder(context, AudioNoiseDatabase::class.java, AUDIONOISE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideAudioNoiseDao(db:AudioNoiseDatabase): AudioNoiseDao = db.getAudioNoiseDao()
}