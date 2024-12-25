package com.example.android.Activity

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.android.ViewModel.MainViewModel

import com.example.android.data.User2

import com.example.android.databinding.ActivityMain8Binding

class MainActivity8 : AppCompatActivity() {
    private lateinit var binding : ActivityMain8Binding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain8Binding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(binding.root)

        mainViewModel.saveStatus.observe(this, Observer { result->
            result.onSuccess { mesaj ->
                binding.textViewYazi.text=mesaj
            }
            result.onFailure { exception ->
                binding.textViewYazi.text=exception.message
            }
        })


        binding.btnDegistir.setOnClickListener {
            var user = User2(null,"uzay","4267462")
            mainViewModel.kelimeKaydet(user)
        }

        }
    }
