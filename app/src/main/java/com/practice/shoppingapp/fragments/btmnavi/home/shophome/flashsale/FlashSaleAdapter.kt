package com.practice.shoppingapp.fragments.btmnavi.home.shophome.flashsale

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemFlashsaleBinding
import com.practice.shoppingapp.models.homeshop.flashsale.FlashSaleData


class FlashSaleAdapter(private val fsList:ArrayList<FlashSaleData>) : RecyclerView.Adapter<FlashSaleAdapter.CategoriesAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapterVH {
      val view = RvItemFlashsaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return CategoriesAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return fsList.size
    }

    override fun onBindViewHolder(holder: CategoriesAdapterVH, position: Int) {
       holder.setData(fsList[position])
       holder.setIsRecyclable(false)
    }

    inner class CategoriesAdapterVH(val binding: RvItemFlashsaleBinding) : RecyclerView.ViewHolder(binding.clFSRoot) {
        fun setData(item : FlashSaleData){
            binding.apply {
                ivCategoriesImg.setImageResource(item.fsImg)
                mtvFSName.text = item.fsName
                mtvFSCodeName.text = item.fsCode
                mtvFSOfferPrice.text = item.fsOfferPrice
                mtvFSOriginalPrice.text = item.fsOriginalPrice
                mtvFSOriginalPrice.paintFlags = mtvFSOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                mtvFSPercentOffer.text = item.fsPercentOffer
            }
        }
    }
}