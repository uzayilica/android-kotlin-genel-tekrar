package com.example.android.mainActivity4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.databinding.ImagelistLayoutBinding

class ImageAdapter(private var imageList: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ImagelistLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ImagelistLayoutBinding.inflate(inflater, parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = imageList[position]
        holder.binding.imageViewResim.setImageResource(image)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setImageList(newList: List<Int>) {
        imageList = newList
        notifyDataSetChanged()
    }
}
