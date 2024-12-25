package com.example.android.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.data.Customer
import com.example.android.data.User
import com.example.android.databinding.RecylerviewcustomerlayoutBinding
import com.example.android.databinding.UserBinding

class CustomerAdapter : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    private var customerList: List<Customer> = listOf()

    class CustomerViewHolder(val binding: RecylerviewcustomerlayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val binding = RecylerviewcustomerlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomerViewHolder(binding)
    }

    override fun getItemCount(): Int = customerList.size

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = customerList[position]
        holder.binding.textViewId.text = customer.id.toString()
        holder.binding.textViewName.text = customer.name ?: "Bilinmiyor"
        holder.binding.textViewCity.text = customer.city ?: "Bilinmiyor"
        holder.binding.textViewYas.text = customer.yas?.toString() ?: "0"
    }

    fun updateCustomerList(newCustomers: List<Customer>) {
        val diffCallback = object : DiffUtil.Callback() {
            override fun getOldListSize() = customerList.size
            override fun getNewListSize() = newCustomers.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return customerList[oldItemPosition].id == newCustomers[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return customerList[oldItemPosition] == newCustomers[newItemPosition]
            }
        }
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        customerList = newCustomers
        diffResult.dispatchUpdatesTo(this)
    }
}
