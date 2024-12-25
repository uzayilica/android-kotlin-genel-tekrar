package com.example.android.mainActivity4

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.android.R
import com.example.android.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private var handler = Handler(Looper.getMainLooper())
    private var currentPage = 0
    private var isAutoSwipeRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val resimList = listOf(
            R.drawable.bir,
            R.drawable.iki,
            R.drawable.uc,
            R.drawable.dort,
            R.drawable.bes
        )

        val imageAdapter = ImageAdapter(resimList)

        binding.viewpager2.adapter = imageAdapter
        binding.viewpager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewpager2a.adapter = imageAdapter
        binding.viewpager2a.orientation = ViewPager2.ORIENTATION_VERTICAL

        binding.dotsIndicator.attachTo(binding.viewpager2)
        binding.dotsIndicator2.attachTo(binding.viewpager2a)

        Toast.makeText(this, "${binding.viewpager2.adapter?.itemCount}", Toast.LENGTH_SHORT).show()

        startAutoSwipe()  // Otomatik kaydırmayı başlat

        // ViewPager2 sayfa değişimini izlemek için callback ekle
        binding.viewpager2.registerOnPageChangeCallback(pageChangeCallback)
    }

    // Otomatik kaydırmayı başlatan fonksiyon
    private fun startAutoSwipe() {
        if (isAutoSwipeRunning) return
        isAutoSwipeRunning = true

        val runnable = object : Runnable {
            override fun run() {
                currentPage = (currentPage + 1) % binding.viewpager2.adapter?.itemCount!!
                binding.viewpager2.setCurrentItem(currentPage, true)
                handler.postDelayed(this, 3000)  // 3 saniyede bir kaydır
            }
        }
        handler.postDelayed(runnable, 3000)  // 3 saniye sonra ilk kaydırmayı yap
    }

    // Otomatik kaydırmayı durduran fonksiyon
    private fun stopAutoSwipe() {
        handler.removeCallbacksAndMessages(null)
        isAutoSwipeRunning = false
    }

    // Activity destroy olduğunda handler temizliği yap
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    // Sayfa değişimini takip etmek için callback
    val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            // Sayfa sürükleniyor, ofset bilgisi
            println("Sayfa $position sürükleniyor, offset: $positionOffset")
        }

        override fun onPageSelected(position: Int) {
            // Sayfa tamamen seçildiğinde çağrılır
            println("Sayfa değişti: yeni sayfa numarası: $position")
        }

        override fun onPageScrollStateChanged(state: Int) {
            when (state) {
                ViewPager2.SCROLL_STATE_IDLE -> {
                    println("Kaydırma tamamlandı")
                    startAutoSwipe()  // Kaydırma tamamlandığında auto swipe'ı tekrar başlat
                }
                ViewPager2.SCROLL_STATE_DRAGGING -> {
                    println("Kullanıcı sürüklüyor")
                    stopAutoSwipe()  // Kullanıcı sürüklüyorsa otomatik kaydırmayı durdur
                }
                ViewPager2.SCROLL_STATE_SETTLING -> {
                    println("Sayfa yerleşiyor")
                }
            }
        }
    }
}
