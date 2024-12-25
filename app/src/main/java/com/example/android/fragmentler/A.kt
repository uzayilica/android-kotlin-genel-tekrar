package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.ViewModel.MyViewModel
import com.example.android.R
import com.example.android.databinding.FragmentABinding


class A : Fragment() {

    private lateinit var myViewModel: MyViewModel

    private lateinit var binding:FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentABinding.inflate(inflater,container,false)
        myViewModel=ViewModelProvider(this).get(MyViewModel::class.java)

       myViewModel.counter.observe(requireActivity(), Observer {
           binding.edittext1.hint=it.toString()
       })


        binding.btnileri.setOnClickListener {
//            findNavController().navigate(R.id.action_a_to_b)
        }

        binding.btnSayacArttir.setOnClickListener {
            myViewModel.incrementCounter();
        }
        binding.btnSayacAzalt.setOnClickListener {
            myViewModel.decrementCounter()
        }

    binding.btnA1eGit.setOnClickListener {
        findNavController().navigate(R.id.action_a_to_a1)
    }

        return binding.root
    }


}