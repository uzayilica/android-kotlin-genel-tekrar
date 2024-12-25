package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.R
import com.example.android.databinding.FragmentABinding
import com.example.android.databinding.FragmentEBinding


class E : Fragment() {
    private lateinit var binding: FragmentEBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEBinding.inflate(inflater,container,false)

        return binding.root    }


}