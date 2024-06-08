package com.practice.shoppingapp.fragments.btmnavi.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.shoppingapp.databinding.RvItemPaymentCartBinding
import com.practice.shoppingapp.models.homeshop.fseemoredata.FSSeeMoreData

class PaymentCartAdapter(private val sCartList:ArrayList<FSSeeMoreData>) : RecyclerView.Adapter<PaymentCartAdapter.PaymentCartAdapterVH>() {

    var onItemClick: ((FSSeeMoreData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentCartAdapterVH {
      val view = RvItemPaymentCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return PaymentCartAdapterVH(view)
    }

    override fun getItemCount(): Int {
       return sCartList.size
    }

    override fun onBindViewHolder(holder: PaymentCartAdapterVH, position: Int) {
        holder.setData(sCartList[position])
        holder.setIsRecyclable(false)
        holder.binding.mcvFSSMRoot.setOnClickListener {
           onItemClick?.invoke(sCartList[position])
        }
    }

    inner class PaymentCartAdapterVH(val binding: RvItemPaymentCartBinding) : RecyclerView.ViewHolder(binding.mcvFSSMRoot) {
        fun setData(item : FSSeeMoreData){
            binding.apply {
                ivFSSMImg.setImageResource(item.fsMoreImg)
                mtvFSSMName.text = item.fsMoreName
                mtvFSSMPrice.text = item.fsMorePrice
                mtvFSSMCode.text = item.fsMoreCode
                mtvFSSMSize.text = "Size: ${item.fsMoreSize}"
                ivFSSMColor.setImageResource(item.fsMoreColor)
            }
        }
    }
}