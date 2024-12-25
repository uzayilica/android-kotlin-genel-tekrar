package com.example.android.fragmentler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.R
import com.example.android.databinding.FragmentIkiBinding


class FragmentIki : Fragment() {
    private lateinit var binding: FragmentIkiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentIkiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnDegistir.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, FragmentBir())
                .addToBackStack(null)
                .commit()
        }

        val sayi =arguments?.getInt("sayi",0)
        binding.textViewVeri.text=sayi.toString()









    }
}