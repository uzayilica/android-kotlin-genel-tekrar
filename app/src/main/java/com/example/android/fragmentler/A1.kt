package com.example.android.fragmentler

import android.net.ipsec.ike.IkeDerAsn1DnIdentification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDestination
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.android.R
import com.example.android.databinding.FragmentA1Binding


class A1 : Fragment() {

    private lateinit var  binding : FragmentA1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentA1Binding.inflate(inflater,container,false)
        binding.btnDegistir.setOnClickListener {
            var action= A1Directions.actionA1ToA2(100)
            findNavController().navigate(action)
        }

        return binding.root
    }



}