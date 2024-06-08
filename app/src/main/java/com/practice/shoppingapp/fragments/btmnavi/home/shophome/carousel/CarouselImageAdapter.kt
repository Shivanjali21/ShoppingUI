package com.practice.shoppingapp.fragments.btmnavi.home.shophome.carousel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.shoppingapp.R
import com.practice.shoppingapp.models.homeshop.carousel.CarouselItem

class CarouselImageAdapter : ListAdapter<CarouselItem, CarouselImageAdapter.ViewHolder>(DiffCallback()){

    class DiffCallback : DiffUtil.ItemCallback<CarouselItem>(){
        override fun areItemsTheSame(oldItem: CarouselItem, newItem: CarouselItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CarouselItem, newItem: CarouselItem): Boolean {
            return oldItem == newItem
        }

    }
    class ViewHolder(iteView: View): RecyclerView.ViewHolder(iteView) {
        private val imageView = iteView.findViewById<ImageView>(R.id.ivCarousel)
        fun bindData(item: CarouselItem){
            Glide.with(itemView)
                .load(item.url)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_carousel,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageItem = getItem(position)
        holder.bindData(imageItem)
    }
}


