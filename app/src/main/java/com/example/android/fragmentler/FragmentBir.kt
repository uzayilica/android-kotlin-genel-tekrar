package com.example.android.fragmentler

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android.Activity.MainActivity2
import com.example.android.R
import com.example.android.data.User
import com.example.android.databinding.FragmentBirBinding


class FragmentBir : Fragment() {
    private lateinit var binding: FragmentBirBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBirBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnDegistir.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, FragmentIki())
                .addToBackStack(null)
                .commit()
        }

        binding.btnIntentDegistir.setOnClickListener {
         var intent = Intent(requireActivity(), MainActivity2::class.java).apply {
               putExtra("username",binding.editTextUsername.text.toString())
               putExtra("password",binding.editTextPassword.text.toString())
             var user = User(1,binding.editTextUsername.text.toString(),binding.editTextPassword.text.toString())
             putExtra("user",user)
         }
            startActivity(intent)

        }

        binding.btnNavigationDegistir.setOnClickListener {
            requireActivity().findNavController(R.id.fragmentContainerView).navigate(R.id.action_fragmentBir_to_fragmentIki)
        }




    }
}