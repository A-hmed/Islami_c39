package com.route.islami_c39.ui.screens.home.fragments.radio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islami_c39.R
import com.route.islami_c39.databinding.FragmentQuranBinding
import com.route.islami_c39.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {
    lateinit var binding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}