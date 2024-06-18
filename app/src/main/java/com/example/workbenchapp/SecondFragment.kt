package com.example.workbenchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workbenchapp.databinding.FragmentSecondaryBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondaryBinding.inflate(layoutInflater)

        return binding.root
    }

}