package com.kidkiller.usoundchallange.core.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.databinding.AudioNoiseItemBinding

class AudioNoiseViewHolder(val binding: AudioNoiseItemBinding,val context: Context): RecyclerView.ViewHolder(binding.root) {

    //val binding = AudioNoiseItemBinding.bind(view)
    fun render(audioNoise: AudioNoiseResponseModel){
        binding.tvLastUpdate.text = audioNoise.lastUpdate
        binding.tvPatient.text = audioNoise.patient.toString()
        binding.tvType.text = audioNoise.type
    }
}