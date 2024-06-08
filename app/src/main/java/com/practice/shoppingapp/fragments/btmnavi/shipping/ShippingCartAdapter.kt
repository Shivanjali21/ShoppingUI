package com.practice.shoppingapp.fragments.btmnavi.shipping

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemShippingCartBinding
import com.practice.shoppingapp.models.homeshop.fseemoredata.FSSeeMoreData

class ShippingCartAdapter(private val sCartList:ArrayList<FSSeeMoreData>) : RecyclerView.Adapter<ShippingCartAdapter.ShippingCartAdapterVH>() {

    //var onItemClick: ((FSSeeMoreData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShippingCartAdapterVH {
      val view = RvItemShippingCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return ShippingCartAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return sCartList.size
    }

    override fun onBindViewHolder(holder: ShippingCartAdapterVH, position: Int) {
        holder.setData(sCartList[position])
        holder.setIsRecyclable(false)
        holder.binding.mcvSCartRoot.setOnClickListener {
          //onItemClick?.invoke(sCartList[position])*/
        }
    }

    inner class ShippingCartAdapterVH(val binding: RvItemShippingCartBinding) : RecyclerView.ViewHolder(binding.mcvSCartRoot) {
        fun setData(item : FSSeeMoreData){
            binding.apply {
                ivSCartImg.setImageResource(item.fsMoreImg)
                mtvSCartName.text = item.fsMoreName
                mtvSCartPrice.text = item.fsMorePrice
                mtvSCartCode.text = item.fsMoreCode
                mtvSCartSize.text = "Size: ${item.fsMoreSize}"
                ivSCartColor.setImageResource(item.fsMoreColor)
            }
        }
    }
}