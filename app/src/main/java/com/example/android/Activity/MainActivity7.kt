package com.example.android.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.android.R
import com.example.android.databinding.ActivityMain7Binding
import com.example.android.mainActivity4.MyFragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity7 : AppCompatActivity() {
    private lateinit var binding: ActivityMain7Binding
    private lateinit var adapter: MyFragmentStateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter= MyFragmentStateAdapter(this)
        binding.viewpager2.adapter=adapter
        TabLayoutMediator(binding.tablayout,binding.viewpager2){tab,position->
            when(position){
                0-> {
                    tab.text ="Gıda"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_home_24)
                    tab.orCreateBadge
                }
                1->{
                    tab.text ="Temizlik"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_login_24)
                }
                2->{
                    tab.text ="Sağlık"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_settings_24)
                }
                3->{
                    tab.text ="Atıştırmalık"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_slideshow_24)
                }
            }
        }.attach()
        }
    }
