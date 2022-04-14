package com.kidkiller.usoundchallange.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kidkiller.usoundchallange.R
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.databinding.AudioNoiseItemBinding

class AudioNoiseAdapter(
    private val audioNoiseList: List<AudioNoiseResponseModel>,
    val itemClickListener: OnAudioNoiseClickListener
) :
    RecyclerView.Adapter<AudioNoiseViewHolder>() {

    interface OnAudioNoiseClickListener {
        fun onAudioNoiseClick(audioNoise: AudioNoiseResponseModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioNoiseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AudioNoiseItemBinding.inflate(layoutInflater, parent, false)
        val holder = AudioNoiseViewHolder(
            layoutInflater.inflate(
                R.layout.audio_noise_item,
                parent,
                false
            )
        )
        binding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION } ?:return@setOnClickListener
            itemClickListener.onAudioNoiseClick(audioNoiseList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: AudioNoiseViewHolder, position: Int) {
        val item = audioNoiseList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = audioNoiseList.size
}