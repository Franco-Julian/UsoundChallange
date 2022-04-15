package com.kidkiller.usoundchallange.core.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.databinding.AudioNoiseItemBinding

class AudioNoiseViewHolder(private val binding: AudioNoiseItemBinding, val context: Context): RecyclerView.ViewHolder(binding.root) {

    fun render(audioNoise: AudioNoiseResponseModel){
        binding.tvLastUpdate.text = audioNoise.lastUpdate
        binding.tvPatient.text = audioNoise.patient.toString()
        binding.tvType.text = audioNoise.type
    }
}