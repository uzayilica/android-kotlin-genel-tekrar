package com.example.android.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.R
import com.example.android.databinding.ActivityMain7Binding
import com.example.android.databinding.ActivityMain9Binding

class MainActivity9 : AppCompatActivity() {
    private lateinit var binding : ActivityMain9Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        }
    }
