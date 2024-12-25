package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.R
import com.example.android.databinding.FragmentA1Binding
import com.example.android.databinding.FragmentA2Binding


class A2 : Fragment() {



    private lateinit var  binding : FragmentA2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentA2Binding.inflate(inflater,container,false)
        binding.btnDegistir.setOnClickListener {
            findNavController().navigate(R.id.action_a2_to_a3)
        }
        return binding.root
    }

}