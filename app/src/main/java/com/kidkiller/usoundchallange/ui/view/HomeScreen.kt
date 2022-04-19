package com.kidkiller.usoundchallange.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kidkiller.usoundchallange.R
import com.kidkiller.usoundchallange.core.adapter.AudioNoiseAdapter
import com.kidkiller.usoundchallange.databinding.FragmentHomeScreenBinding
import com.kidkiller.usoundchallange.domain.model.AudioNoise
import com.kidkiller.usoundchallange.ui.viewmodel.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.fragment_home_screen), AudioNoiseAdapter.OnAudioNoiseClickListener  {

    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var adapter: AudioNoiseAdapter
    private var audioNoise = mutableListOf<AudioNoise>()
    private lateinit var layoutManager : LinearLayoutManager

    private val homeScreenViewModel: HomeScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeScreenViewModel.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)


        lifecycleScope.launchWhenStarted {
            homeScreenViewModel.audioNoiseList.collectLatest {
                if (!it.isNullOrEmpty()) initRecyclerView(it)
            }
        }
/*        homeScreenViewModel.audioNoiseList.observe(viewLifecycleOwner) {

        }*/
        homeScreenViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.idProgress.isVisible = it
        }

    }

    private fun initRecyclerView(list: List<AudioNoise>){
        adapter = AudioNoiseAdapter(list,this)
        layoutManager = LinearLayoutManager(context)
        binding.recyclerAudioNoise.layoutManager = layoutManager
        binding.recyclerAudioNoise.adapter = adapter
    }


    override fun onAudioNoiseClick(audioNoise: AudioNoise) {
        val action = HomeScreenDirections.actionHomeScreenToSoundNoiseDetail(
            audioNoise.id,
            audioNoise.type,
            audioNoise.anc_activated,
            audioNoise.frequency,
            audioNoise.channel,
            audioNoise.hearingThresholdDifference,
            audioNoise.avgSoundPressureLevelDifference,
            audioNoise.instantSoundPressureLevelDifference,
            audioNoise.avgDistanceDifference,
            audioNoise.freqInstantIntensityDifference,
            audioNoise.freqAvgIntensityDifference,
            audioNoise.lastUpdate,
            audioNoise.timestamp,
            audioNoise.patient
        )
            findNavController().navigate(action)
    }
}