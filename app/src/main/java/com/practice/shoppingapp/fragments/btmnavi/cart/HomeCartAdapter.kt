package com.practice.shoppingapp.fragments.btmnavi.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.RvItemCartBinding
import com.practice.shoppingapp.databinding.RvItemFsSeemoreBinding
import com.practice.shoppingapp.models.homecart.HomeCartData
import com.practice.shoppingapp.models.homeshop.fseemoredata.FSSeeMoreData

class HomeCartAdapter(private val cartList:ArrayList<HomeCartData>) : RecyclerView.Adapter<HomeCartAdapter.HomeCartAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCartAdapterVH {
      val view = RvItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return HomeCartAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return cartList.size
    }

    override fun onBindViewHolder(holder: HomeCartAdapterVH, position: Int) {
       holder.setData(cartList[position])
       holder.setIsRecyclable(false)
    }

    inner class HomeCartAdapterVH(val binding: RvItemCartBinding) : RecyclerView.ViewHolder(binding.mcvCartRoot) {
        fun setData(item : HomeCartData){
            binding.apply {
                ivCartImg.setImageResource(item.cartImg)
                mtvCartName.text = item.cartName
                mtvFSSMCode.text = item.cartCode
                mtvCartPrice.text = item.cartPrice
                mtvCartQty.text = item.cartQty.toString()
                mtvCartTotal.text = item.cartTotal
                mtvCartSize.text = item.cartSize
                ivCartColor.setImageResource(item.cartColor)
            }
        }
    }
}