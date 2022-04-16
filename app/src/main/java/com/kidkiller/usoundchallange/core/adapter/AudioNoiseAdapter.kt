package com.kidkiller.usoundchallange.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.databinding.AudioNoiseItemBinding
import com.kidkiller.usoundchallange.domain.model.AudioNoise

class AudioNoiseAdapter(
    private val audioNoiseList: List<AudioNoise>,
    private val itemClickListener: OnAudioNoiseClickListener
) : RecyclerView.Adapter<AudioNoiseViewHolder>() {

    interface OnAudioNoiseClickListener {
        fun onAudioNoiseClick(audioNoise: AudioNoise)
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioNoiseViewHolder {
        val itemBinding = AudioNoiseItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val holder = AudioNoiseViewHolder(itemBinding,parent.context)
            itemBinding.root.setOnClickListener {
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