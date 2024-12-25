package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.R
import com.example.android.databinding.FragmentABinding
import com.example.android.databinding.FragmentCBinding


class C : Fragment() {
    private lateinit var binding: FragmentCBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCBinding.inflate(inflater,container,false)
        binding.btnileri.setOnClickListener {
            findNavController().navigate(R.id.action_c_to_d)
        }
        return binding.root    }


}