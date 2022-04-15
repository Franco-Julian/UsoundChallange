package com.kidkiller.usoundchallange.data.model

import com.google.gson.annotations.SerializedName

data class AudioNoiseResponseModel(
    @SerializedName("id") var id: Int,
    @SerializedName("type") var type: String,
    @SerializedName("anc_activated") var anc_activated: Boolean,
    @SerializedName("frequency") var frequency: Int,
    @SerializedName("channel") var channel: String,
    @SerializedName("hearing_threshold_difference") var hearingThresholdDifference: Float,
    @SerializedName("avg_sound_pressure_level_difference") var avgSoundPressureLevelDifference: Float,
    @SerializedName("instant_sound_pressure_level_difference") var instantSoundPressureLevelDifference: Float,
    @SerializedName("avg_distance_difference") var avgDistanceDifference: Float,
    @SerializedName("freq_instant_intensity_difference") var freqInstantIntensityDifference: Float,
    @SerializedName("freq_avg_intensity_difference") var freqAvgIntensityDifference: Float,
    @SerializedName("last_update") var lastUpdate: String,
    @SerializedName("timestamp") var timestamp: String,
    @SerializedName("patient") var patient: Int
)