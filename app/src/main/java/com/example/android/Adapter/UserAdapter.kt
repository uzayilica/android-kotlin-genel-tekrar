package com.example.android.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.data.User

class UserAdapter(var context: Context, var userList:List<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    fun bind(holder: UserViewHolder, user: User){

        holder.imageViewImage.setOnClickListener{
            Toast.makeText(context,"resme tıklandı ",Toast.LENGTH_SHORT).show()
        }

        holder.textViewId.setOnClickListener {
            Toast.makeText(context,"id'ye tıklandı ${user.id}",Toast.LENGTH_SHORT).show()

        }
        holder.textViewName.setOnClickListener {
            Toast.makeText(context,"Name değerine tıklandı ${user.username} ",Toast.LENGTH_SHORT).show()

        }
        holder.textViewPassword.setOnClickListener {
            Toast.makeText(context,"password değerine tıklandı ${user.password} ",Toast.LENGTH_SHORT).show()

        }


            }


    class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var textViewId:TextView = itemView.findViewById(R.id.textViewId)
        var textViewName:TextView=itemView.findViewById(R.id.textViewUsername)
        var textViewPassword:TextView=itemView.findViewById(R.id.textViewPassword)
        var imageViewImage : ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.user,parent,false)
        return  UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user =userList[position]
        holder.textViewId.text=user.id.toString()
        holder.textViewName.text=user.username
        holder.textViewPassword.text=user.password
        holder.imageViewImage.setImageResource(R.drawable.resim)
        bind(holder,user)


    }

    override fun getItemCount(): Int {
        return userList.size
    }
}