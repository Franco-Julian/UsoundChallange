package com.kidkiller.usoundchallange.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kidkiller.usoundchallange.data.database.entities.AudioNoiseEntity

@Dao
interface AudioNoiseDao {

    @Query("SELECT * FROM audio_noise_table")
    suspend fun getAllAudioNoise(): List<AudioNoiseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(audioNoises: List<AudioNoiseEntity>)

    @Query("DELETE FROM audio_noise_table")
    suspend fun deleteAllAudioNoise()
}