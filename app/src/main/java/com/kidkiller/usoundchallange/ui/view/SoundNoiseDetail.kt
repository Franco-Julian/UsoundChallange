package com.kidkiller.usoundchallange.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.kidkiller.usoundchallange.R
import com.kidkiller.usoundchallange.databinding.FragmentSoundNoiseDetailBinding

class SoundNoiseDetail : Fragment(R.layout.fragment_sound_noise_detail) {

    private lateinit var binding: FragmentSoundNoiseDetailBinding
    private val args by navArgs<SoundNoiseDetailArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSoundNoiseDetailBinding.bind(view)
        loadDetailsInfo()
    }

    private fun loadDetailsInfo() {
        binding.tvId.text = args.id.toString()
        binding.tvType.text = args.type
        binding.tvAnc.text = args.anc.toString()
        binding.tvFrequency.text = args.frequency.toString()
        binding.tvChannel.text = args.channel
        binding.tvHearingThresholdDifference.text = args.hearingThresholdDifference.toString()
        binding.tvAvgSoundPressureLevelDifference.text = args.avgSoundPressureLevelDifference.toString()
        binding.tvInstantSoundPressureLevelDifference.text = args.instantSoundPressureLevelDifference.toString()
        binding.tvAvgDistanceDifference.text = args.avgDistanceDifference.toString()
        binding.tvFreqInstantIntensityDifference.text = args.freqInstantIntensityDifference.toString()
        binding.tvFreqAvgIntensityDifference.text = args.freqAvgIntensityDifference.toString()
        binding.tvLastUpdate.text = args.lastUpdate
        binding.tvTimestamp.text = args.timestamp
        binding.tvPatient.text = args.patient.toString()
    }
}