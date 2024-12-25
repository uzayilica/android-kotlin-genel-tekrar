package com.example.android.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.android.R
import com.example.android.data.User
import com.example.android.databinding.UserBinding

class UserAdapter4(private val context: Context) : RecyclerView.Adapter<UserAdapter4.UserViewHolder>() {

    private var userList: MutableList<User> = mutableListOf()

    class UserViewHolder(var binding: UserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.textViewId.text = user.id.toString()
        holder.binding.textViewUsername.text = user.username
        holder.binding.textViewPassword.text = user.password
        holder.binding.imageView.setImageResource(R.drawable.resim2)

        holder.binding.imageView.setOnClickListener {
            Toast.makeText(context, "Resme Tıklandı: ${user.username}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = userList.size

    fun setUserList(users: List<User>) {
        this.userList = users.toMutableList()
        notifyDataSetChanged()
    }

    fun moveItem(fromPosition: Int, toPosition: Int) {
        val movedUser = userList.removeAt(fromPosition)
        userList.add(toPosition, movedUser)
        notifyItemMoved(fromPosition, toPosition)
    }

    fun attachItemTouchHelper(recyclerView: RecyclerView) {
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                moveItem(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                userList.removeAt(position)
                notifyItemRemoved(position)
                Toast.makeText(context, "Kullanıcı silindi", Toast.LENGTH_SHORT).show()
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}
