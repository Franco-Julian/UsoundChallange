package com.kidkiller.usoundchallange.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.kidkiller.usoundchallange.R
import com.kidkiller.usoundchallange.databinding.FragmentHomeScreenBinding


class HomeScreen : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)
    }
}