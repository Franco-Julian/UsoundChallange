package com.kidkiller.usoundchallange.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kidkiller.usoundchallange.data.database.dao.AudioNoiseDao
import com.kidkiller.usoundchallange.data.database.entities.AudioNoiseEntity

@Database(entities = [AudioNoiseEntity::class], version = 1)
abstract class AudioNoiseDatabase: RoomDatabase() {

    abstract fun getAudioNoiseDao(): AudioNoiseDao
}