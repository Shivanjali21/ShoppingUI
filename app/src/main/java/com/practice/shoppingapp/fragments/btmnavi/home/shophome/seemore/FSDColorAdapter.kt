package com.practice.shoppingapp.fragments.btmnavi.home.shophome.seemore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemFsdColorBinding
import com.practice.shoppingapp.models.homeshop.fsdcolordata.FSDColorData
class FSDColorAdapter(private val categoriesList:ArrayList<FSDColorData>) : RecyclerView.Adapter<FSDColorAdapter.ColorAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorAdapterVH {
      val view = RvItemFsdColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return ColorAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return categoriesList.size
    }

    override fun onBindViewHolder(holder: ColorAdapterVH, position: Int) {
       holder.setData(categoriesList[position])
       holder.setIsRecyclable(false)
    }

    inner class ColorAdapterVH(val binding: RvItemFsdColorBinding) : RecyclerView.ViewHolder(binding.clColorRoot) {
        fun setData(item : FSDColorData){
            binding.apply {
                ivFSDColor.setImageResource(item.fsdColorName)
            }
        }
    }
}