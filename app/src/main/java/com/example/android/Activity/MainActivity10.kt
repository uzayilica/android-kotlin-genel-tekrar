package com.example.android.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android.Adapter.CarsAdapter
import com.example.android.R
import com.example.android.data.Cars
import com.example.android.databinding.ActivityMain10Binding

class MainActivity10 : AppCompatActivity() {
    private lateinit var binding : ActivityMain10Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain10Binding.inflate(layoutInflater)
        setContentView(binding.root)
            var carAdapter =CarsAdapter(this);
            var carList = listOf(
                Cars("Hyundai", "i20", 2024, 89),
                Cars("Toyota", "Corolla", 2024, 85),
                Cars("Ford", "Focus", 2024, 90),
                Cars("Volkswagen", "Golf", 2024, 88),
                Cars("Honda", "Civic", 2024, 91),
                Cars("Nissan", "Sentra", 2024, 87),
                Cars("Chevrolet", "Cruze", 2024, 86),

            )
        carAdapter.setCarList(carList)

        binding.recylerviewCars.adapter=carAdapter

    }
}