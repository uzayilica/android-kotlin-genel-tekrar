package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.R
import com.example.android.databinding.FragmentA1Binding
import com.example.android.databinding.FragmentA2Binding
import com.example.android.databinding.FragmentA3Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class A3 : Fragment() {



    private lateinit var  binding : FragmentA3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentA3Binding.inflate(inflater,container,false)
        return binding.root
    }



}