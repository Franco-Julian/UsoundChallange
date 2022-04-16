package com.kidkiller.usoundchallange.domain.model

import com.google.gson.annotations.SerializedName
import com.kidkiller.usoundchallange.data.database.entities.AudioNoiseEntity
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel

data class AudioNoise(
    var id: Int,
    var type: String,
    var anc_activated: Boolean,
    var frequency: Int,
    var channel: String,
    var hearingThresholdDifference: Float,
    var avgSoundPressureLevelDifference: Float,
    var instantSoundPressureLevelDifference: Float,
    var avgDistanceDifference: Float,
    var freqInstantIntensityDifference: Float,
    var freqAvgIntensityDifference: Float,
    var lastUpdate: String,
    var timestamp: String,
    var patient: Int
)

fun AudioNoiseResponseModel.toDomain() = AudioNoise(
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

fun AudioNoiseEntity.toDomain() = AudioNoise(
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