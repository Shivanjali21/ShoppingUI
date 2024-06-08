package com.practice.shoppingapp.fragments.btmnavi.home.shophome.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemCategoriesBinding
import com.practice.shoppingapp.models.homeshop.categories.CategoriesData

class CategoriesAdapter(private val categoriesList:ArrayList<CategoriesData>) : RecyclerView.Adapter<CategoriesAdapter.CategoriesAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapterVH {
      val view = RvItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return CategoriesAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoriesAdapterVH, position: Int) {
       holder.setData(categoriesList[position])
       holder.setIsRecyclable(false)
    }

    inner class CategoriesAdapterVH(val binding: RvItemCategoriesBinding) : RecyclerView.ViewHolder(binding.clCategoriesRoot) {
        fun setData(item : CategoriesData){
            binding.apply {
                ivCategoriesImg.setImageResource(categoriesList[bindingAdapterPosition].cImg)
                mtvCategoriesName.text = item.cName
            }
        }
    }
}