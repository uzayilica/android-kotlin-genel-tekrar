package com.example.android.mainActivity5

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.android.R
import com.example.android.databinding.ActivityMain5Binding
import com.example.android.mainActivity4.ImageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)


        var imageList = listOf(
            R.drawable.bir,
            R.drawable.iki,
            R.drawable.uc,
            R.drawable.dort,
            R.drawable.bes
        )

        binding.viewpager2.adapter=ImageAdapter(imageList)
        binding.viewpager2.orientation=ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(binding.tablayout,binding.viewpager2){tab,position->
            when(position){
                0-> {
                    tab.text ="uzay"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.az)
                    tab.orCreateBadge
                }
                1->{
                    tab.text ="uzay 2"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.tr)
                }
            }
        }.attach()


        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Seçilen sekme ile ilgili işlemler
                Toast.makeText(this@MainActivity5,"${tab?.text } sekme seçildi",Toast.LENGTH_SHORT).show()
                tab?.removeBadge()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity5,"${tab?.text } sekme kapatıldı ",Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity5,"${tab?.text } zaten bu sekmedesiniz ",Toast.LENGTH_SHORT).show()
                tab?.removeBadge()

            }
        })




    }
}
