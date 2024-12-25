package com.example.android.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.data.User
import com.example.android.databinding.UserBinding

class UserAdapter2 (var context: Context, var userlist:List<User>):RecyclerView.Adapter<UserAdapter2.UserViewHolder>() {


    fun bind (holder: UserViewHolder, user: User){

        holder.binding.imageView.setOnClickListener{
            Toast.makeText(context,"Resme Tıklandı ${user.username}",Toast.LENGTH_SHORT).show()
        }

    }


    class UserViewHolder (var binding:UserBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user =userlist[position]
        holder.binding.textViewId.text = user.id.toString()
        holder.binding.textViewUsername.text = user.username
        holder.binding.textViewPassword.text = user.password
        holder.binding.imageView.setImageResource(R.drawable.resim3)
        bind(holder,user)

    }

    override fun getItemCount(): Int {
       return userlist.size;
    }
}