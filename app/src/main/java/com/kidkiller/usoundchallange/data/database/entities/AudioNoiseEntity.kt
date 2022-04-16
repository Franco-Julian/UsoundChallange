package com.kidkiller.usoundchallange.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kidkiller.usoundchallange.domain.model.AudioNoise

@Entity(tableName = "audio_noise_table")
data class AudioNoiseEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "anc_activated") var anc_activated: Boolean,
    @ColumnInfo(name = "frequency") var frequency: Int,
    @ColumnInfo(name = "channel") var channel: String,
    @ColumnInfo(name = "hearing_threshold_difference") var hearingThresholdDifference: Float,
    @ColumnInfo(name = "avg_sound_pressure_level_difference") var avgSoundPressureLevelDifference: Float,
    @ColumnInfo(name = "instant_sound_pressure_level_difference") var instantSoundPressureLevelDifference: Float,
    @ColumnInfo(name = "avg_distance_difference") var avgDistanceDifference: Float,
    @ColumnInfo(name = "freq_instant_intensity_difference") var freqInstantIntensityDifference: Float,
    @ColumnInfo(name = "freq_avg_intensity_difference") var freqAvgIntensityDifference: Float,
    @ColumnInfo(name = "last_update") var lastUpdate: String,
    @ColumnInfo(name = "timestamp") var timestamp: String,
    @ColumnInfo(name = "patient") var patient: Int
)

fun AudioNoise.toDatabase() = AudioNoiseEntity(
    id,
    type,
    anc_activated,
    frequency,
    channel,
    hearingThresholdDifference,
    avgSoundPressureLevelDifference,
    instantSoundPressureLevelDifference,
    avgDistanceDifference,
    freqInstantIntensityDifference,
    freqAvgIntensityDifference,
    lastUpdate,
    timestamp,
    patient
)