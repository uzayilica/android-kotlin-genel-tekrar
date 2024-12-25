package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.R
import com.example.android.data.User
import com.example.android.Adapter.UserAdapter
import com.example.android.databinding.FragmentBBinding


class B : Fragment() {
    private lateinit var binding: FragmentBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentBBinding.inflate(inflater,container,false)
        binding.btnileri.setOnClickListener {
            findNavController().navigate(R.id.action_b_to_c)
        }


        var userList = listOf(
            User(1,"uzay","4267462"),
            User(2,"uzay","4267462"),
            User(3,"uzay","4267462"),
            User(4,"uzay","4267462")
        )
        binding.recylerview.adapter= UserAdapter(requireContext(),userList)
        binding.recylerview.layoutManager=LinearLayoutManager(requireContext())
        return binding.root


    }


}