package com.kidkiller.usoundchallange.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kidkiller.usoundchallange.R
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel

class AudioNoiseAdapter(private val audioNoiseList: List<AudioNoiseResponseModel>) :
    RecyclerView.Adapter<AudioNoiseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioNoiseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AudioNoiseViewHolder(
            layoutInflater.inflate(
                R.layout.audio_noise_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AudioNoiseViewHolder, position: Int) {
        val item = audioNoiseList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = audioNoiseList.size
}