package com.example.android.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.Adapter.UserAdapter4.UserViewHolder
import com.example.android.data.Cars
import com.example.android.data.User
import com.example.android.databinding.CarLayoutBinding
import com.example.android.databinding.UserBinding

class CarsAdapter (private val context: Context): RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {
    private var carList: MutableList<Cars> = mutableListOf()
    class CarsViewHolder(var binding: CarLayoutBinding) : RecyclerView.ViewHolder(binding.root){



}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val binding = CarLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  carList.size
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val car = carList[position]
        holder.binding.textViewName.text=car.name
        holder.binding.textViewModel.text=car.model
        holder.binding.textViewFiyat.text=car.fiyat.toString()
        holder.binding.textViewYapimYili.text=car.yapimYili.toString()
    }

    fun setCarList(cars: List<Cars>) {
        this.carList = cars.toMutableList()
        notifyDataSetChanged()
    }
}