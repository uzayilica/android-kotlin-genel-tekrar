package com.example.android.Activity

import CustomerViewModel
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.Adapter.CustomerAdapter
import com.example.android.data.Customer
import com.example.android.databinding.ActivitySonBinding

class SonActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonBinding
    private lateinit var customerViewModel: CustomerViewModel
    private lateinit var customerAdapter: CustomerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()
        setupObservers()
        setupClickListeners()

        customerViewModel.getAllCustomers()
    }

    private fun setupViewModel() {
        customerViewModel = ViewModelProvider(this)[CustomerViewModel::class.java]
        customerAdapter = CustomerAdapter()
    }

    private fun setupRecyclerView() {
        binding.recylerViewUser.apply {
            layoutManager = LinearLayoutManager(this@SonActivity)
            adapter = customerAdapter
        }
    }

    private fun setupObservers() {
        customerViewModel.customers.observe(this) { result ->
            result.getOrNull()?.let { customers ->
                customerAdapter.updateCustomerList(customers)
            } ?: run {
                // Handle error case
                Toast.makeText(this, "Müşteri listesi yüklenemedi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupClickListeners() {
        binding.buttonEkle.setOnClickListener {
            addCustomer()
        }

        binding.buttonSil.setOnClickListener {
            // Implement delete functionality
        }

        binding.buttonGoruntule.setOnClickListener {
            customerViewModel.getAllCustomers()
        }
    }

    private fun addCustomer() {
        try {
            val id = binding.editTextId.text.toString().toIntOrNull()
            val name = binding.editTextName.text.toString()
            val city = binding.editTextCity.text.toString()
            val age = binding.editTextYas.text.toString().toIntOrNull()

            if (validateInput(name, city)) {
                val customer = Customer(id, name, city, age)
                customerViewModel.addCustomer(customer)
                clearInputFields()
            } else {
                Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Müşteri eklenirken bir hata oluştu", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(name: String, city: String): Boolean {
        return name.isNotBlank() && city.isNotBlank()
    }

    private fun clearInputFields() {
        binding.apply {
            editTextId.text.clear()
            editTextName.text.clear()
            editTextCity.text.clear()
            editTextYas.text.clear()
        }
    }
}