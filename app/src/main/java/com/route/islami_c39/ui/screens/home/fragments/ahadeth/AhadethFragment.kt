package com.route.islami_c39.ui.screens.home.fragments.ahadeth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islami_c39.R
import com.route.islami_c39.databinding.FragmentAhadethBinding
import com.route.islami_c39.databinding.FragmentQuranBinding

class AhadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}