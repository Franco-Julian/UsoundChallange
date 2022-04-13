package com.kidkiller.usoundchallange.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kidkiller.usoundchallange.R
import com.kidkiller.usoundchallange.core.adapter.AudioNoiseAdapter
import com.kidkiller.usoundchallange.data.model.AudioNoiseResponseModel
import com.kidkiller.usoundchallange.databinding.FragmentHomeScreenBinding
import com.kidkiller.usoundchallange.ui.viewmodel.HomeScreenViewModel


class HomeScreen : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var adapter: AudioNoiseAdapter

    private val homeScreenViewModel: HomeScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        homeScreenViewModel.onCreate()

        homeScreenViewModel.audioNoiseList.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) initRecyclerView(it)
        })

        homeScreenViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.idProgress.isVisible = it
        })
    }

    private fun initRecyclerView(list: List<AudioNoiseResponseModel>){
        adapter = AudioNoiseAdapter(list)
        binding.recyclerAudioNoise.layoutManager = LinearLayoutManager(context)
        binding.recyclerAudioNoise.adapter = adapter
    }
}