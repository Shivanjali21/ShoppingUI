package com.practice.shoppingapp.fragments.btmnavi.home.shophome.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemCategoriesBinding
import com.practice.shoppingapp.databinding.RvItemNotificationBinding
import com.practice.shoppingapp.models.homeshop.categories.CategoriesData
import com.practice.shoppingapp.models.homeshop.notiData.NotiData

class NotificationAdapter(private val notiList:ArrayList<NotiData>) : RecyclerView.Adapter<NotificationAdapter.CategoriesAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapterVH {
      val view = RvItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return CategoriesAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return notiList.size
    }

    override fun onBindViewHolder(holder: CategoriesAdapterVH, position: Int) {
       holder.setData(notiList[position])
       holder.setIsRecyclable(false)
    }

    inner class CategoriesAdapterVH(val binding: RvItemNotificationBinding) : RecyclerView.ViewHolder(binding.mcvNotiRoot) {
        fun setData(item : NotiData){
            binding.apply {
                ivNotiImg.setImageResource(notiList[bindingAdapterPosition].notiImg)
                mtvNotiName.text = item.notiName
                mtvNotiTime.text = item.notiTime
            }
        }
    }
}