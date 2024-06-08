package com.practice.shoppingapp.fragments.btmnavi.home.shophome.seemore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemFsdSizeBinding
import com.practice.shoppingapp.models.homeshop.fsdsizedata.FSDSizeData

class FSDSizeAdapter(private val categoriesList:ArrayList<FSDSizeData>) : RecyclerView.Adapter<FSDSizeAdapter.SizeAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeAdapterVH {
      val view = RvItemFsdSizeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return SizeAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return categoriesList.size
    }

    override fun onBindViewHolder(holder: SizeAdapterVH, position: Int) {
       holder.setData(categoriesList[position])
       holder.setIsRecyclable(false)
    }

    inner class SizeAdapterVH(val binding: RvItemFsdSizeBinding) : RecyclerView.ViewHolder(binding.clSizeRoot) {
        fun setData(item : FSDSizeData){
            binding.apply {
                mtvCategoriesName.text = item.fsdSizeName
            }
        }
    }
}