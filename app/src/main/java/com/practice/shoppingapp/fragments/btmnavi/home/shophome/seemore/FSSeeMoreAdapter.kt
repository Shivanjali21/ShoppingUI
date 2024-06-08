package com.practice.shoppingapp.fragments.btmnavi.home.shophome.seemore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemFsSeemoreBinding
import com.practice.shoppingapp.models.homeshop.fseemoredata.FSSeeMoreData

class FSSeeMoreAdapter(private val fsSMList:ArrayList<FSSeeMoreData>) : RecyclerView.Adapter<FSSeeMoreAdapter.FSSeeMoreAdapterVH>() {

    var onItemClick: ((FSSeeMoreData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FSSeeMoreAdapterVH {
      val view = RvItemFsSeemoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return FSSeeMoreAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return fsSMList.size
    }

    override fun onBindViewHolder(holder: FSSeeMoreAdapterVH, position: Int) {
        holder.setData(fsSMList[position])
        holder.setIsRecyclable(false)
        holder.binding.mcvFSSMRoot.setOnClickListener {
           onItemClick?.invoke(fsSMList[position])
        }
    }

    inner class FSSeeMoreAdapterVH(val binding: RvItemFsSeemoreBinding) : RecyclerView.ViewHolder(binding.mcvFSSMRoot) {
        fun setData(item : FSSeeMoreData){
            binding.apply {
                ivFSSMImg.setImageResource(fsSMList[bindingAdapterPosition].fsMoreImg)
                mtvFSSMName.text = item.fsMoreName
                mtvFSSMPrice.text = item.fsMorePrice
                mtvFSSMCode.text = item.fsMoreCode
                mtvFSSMSize.text = "Size: ${item.fsMoreSize}"
                ivFSSMColor.setImageResource(item.fsMoreColor)
            }
        }
    }
}